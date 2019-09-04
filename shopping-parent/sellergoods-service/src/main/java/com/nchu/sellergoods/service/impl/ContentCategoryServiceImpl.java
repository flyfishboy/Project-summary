package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ContentCategoryMapper;
import com.nchu.model.ContentCategory;
import com.nchu.model.ContentCategoryExample;
import com.nchu.model.ContentCategoryExample.Criteria;
import com.nchu.sellergoods.service.ContentCategoryService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper ContentCategoryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ContentCategory> findAll() {
		return ContentCategoryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<ContentCategory> page=   (Page<ContentCategory>) ContentCategoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ContentCategory ContentCategory) {
		ContentCategoryMapper.insert(ContentCategory);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ContentCategory ContentCategory){
		ContentCategoryMapper.updateByPrimaryKey(ContentCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ContentCategory findOne(Long id){
		return ContentCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			ContentCategoryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(ContentCategory ContentCategory, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ContentCategoryExample example=new ContentCategoryExample();
		Criteria criteria = example.createCriteria();
		
		if(ContentCategory!=null){			
						if(ContentCategory.getName()!=null && ContentCategory.getName().length()>0){
				criteria.andNameLike("%"+ContentCategory.getName()+"%");
			}
	
		}
		
		Page<ContentCategory> page= (Page<ContentCategory>)ContentCategoryMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
