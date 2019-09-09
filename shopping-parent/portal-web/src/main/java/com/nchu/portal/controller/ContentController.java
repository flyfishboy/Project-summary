package com.nchu.portal.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.nchu.content.service.ContentService;
import com.nchu.model.Content;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	/**
	 * 根据广告分类ID查询广告列表
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/findByCategoryId")
	public List<Content> findByCategoryId(Long categoryId) {
		return contentService.findByCategortId(categoryId);
	}
}
