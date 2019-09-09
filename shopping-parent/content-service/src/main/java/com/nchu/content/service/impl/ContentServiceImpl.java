package com.nchu.content.service.impl;
import java.util.List;

import com.nchu.mapper.ContentCategoryMapper;
import com.nchu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ContentMapper;
import com.nchu.model.ContentExample.Criteria;
import com.nchu.content.service.ContentService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<Content> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Content> page=   (Page<Content>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Content content) {
		contentMapper.insert(content);		
	}

	@Override
	public List<Content> findByCategortId(Long categoryId) {

		List<Content> contents = null;
		ContentExample contentExample = new ContentExample();
		Criteria criteria = contentExample.createCriteria();
		//根据广告类查询列表
		criteria.andCategoryIdEqualTo(categoryId);
		criteria.andStatusEqualTo("1");//开启状态
		contentExample.setOrderByClause("sort_order");//排序
		contents = contentMapper.selectByExample(contentExample);
		return contents;
	}
	
	/**
	 * 修改
	 */
	@Override
	public void update(Content content){
		contentMapper.updateByPrimaryKey(content);
	}	



	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Content findOne(Long id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			contentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Content content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ContentExample example=new ContentExample();
		Criteria criteria = example.createCriteria();
		
		if(content!=null){			
						if(content.getTitle()!=null && content.getTitle().length()>0){
				criteria.andTitleLike("%"+content.getTitle()+"%");
			}
			if(content.getUrl()!=null && content.getUrl().length()>0){
				criteria.andUrlLike("%"+content.getUrl()+"%");
			}
			if(content.getPic()!=null && content.getPic().length()>0){
				criteria.andPicLike("%"+content.getPic()+"%");
			}
			if(content.getStatus()!=null && content.getStatus().length()>0){
				criteria.andStatusLike("%"+content.getStatus()+"%");
			}
	
		}
		
		Page<Content> page= (Page<Content>)contentMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
