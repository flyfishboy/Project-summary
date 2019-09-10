package com.nchu.portal.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.nchu.content.service.ContentService;
import com.nchu.model.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	/**
	 * 根据广告分类ID查询广告列表
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/findByCategoryId")
	public List<Content> findByCategoryId(Long categoryId) {
		List<Content> contentList = null;
		//先从redis中取出数据
		contentList = (List<Content>)redisTemplate.boundHashOps("content").get("categoryId");
		//取出数据做判断
		if (contentList == null||contentList.size()==0) {
			contentList = contentService.findByCategortId(categoryId);
			redisTemplate.boundHashOps("content").put("categoryId",contentList);
			redisTemplate.boundHashOps("content").expire(600, TimeUnit.SECONDS);
		}
		return contentList;
	}
}
