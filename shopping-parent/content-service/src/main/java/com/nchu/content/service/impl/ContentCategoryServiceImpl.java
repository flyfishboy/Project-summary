package com.nchu.content.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ContentCategoryMapper;
import com.nchu.model.ContentCategory;
import com.nchu.model.ContentCategoryExample;
import com.nchu.model.ContentCategoryExample.Criteria;
import com.nchu.content.service.ContentCategoryService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper contentCategoryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ContentCategory> findAll() {
		return contentCategoryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<ContentCategory> page=   (Page<ContentCategory>) contentCategoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ContentCategory contentCategory) {
		contentCategoryMapper.insert(contentCategory);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ContentCategory contentCategory){
		contentCategoryMapper.updateByPrimaryKey(contentCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ContentCategory findOne(Long id){
		return contentCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			contentCategoryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(ContentCategory category, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ContentCategoryExample example=new ContentCategoryExample();
		Criteria criteria = example.createCriteria();
		
		if(category!=null){			
						if(category.getName()!=null && category.getName().length()>0){
				criteria.andNameLike("%"+category.getName()+"%");
			}
	
		}
		
		Page<ContentCategory> page= (Page<ContentCategory>)contentCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
