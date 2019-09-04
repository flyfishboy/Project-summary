package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.TypeTemplateMapper;
import com.nchu.model.TypeTemplate;
import com.nchu.model.TypeTemplateExample;
import com.nchu.model.TypeTemplateExample.Criteria;
import com.nchu.sellergoods.service.TypeTemplateService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TypeTemplateMapper TypeTemplateMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TypeTemplate> findAll() {
		return TypeTemplateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TypeTemplate> page=   (Page<TypeTemplate>) TypeTemplateMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TypeTemplate TypeTemplate) {
		TypeTemplateMapper.insert(TypeTemplate);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TypeTemplate TypeTemplate){
		TypeTemplateMapper.updateByPrimaryKey(TypeTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TypeTemplate findOne(Long id){
		return TypeTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			TypeTemplateMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TypeTemplate TypeTemplate, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TypeTemplateExample example=new TypeTemplateExample();
		Criteria criteria = example.createCriteria();
		
		if(TypeTemplate!=null){			
						if(TypeTemplate.getName()!=null && TypeTemplate.getName().length()>0){
				criteria.andNameLike("%"+TypeTemplate.getName()+"%");
			}
			if(TypeTemplate.getSpecIds()!=null && TypeTemplate.getSpecIds().length()>0){
				criteria.andSpecIdsLike("%"+TypeTemplate.getSpecIds()+"%");
			}
			if(TypeTemplate.getBrandIds()!=null && TypeTemplate.getBrandIds().length()>0){
				criteria.andBrandIdsLike("%"+TypeTemplate.getBrandIds()+"%");
			}
			if(TypeTemplate.getCustomAttributeItems()!=null && TypeTemplate.getCustomAttributeItems().length()>0){
				criteria.andCustomAttributeItemsLike("%"+TypeTemplate.getCustomAttributeItems()+"%");
			}
	
		}
		
		Page<TypeTemplate> page= (Page<TypeTemplate>)TypeTemplateMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
