package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.SpecificationOptionMapper;
import com.nchu.model.SpecificationOption;
import com.nchu.model.SpecificationOptionExample;
import com.nchu.model.SpecificationOptionExample.Criteria;
import com.nchu.sellergoods.service.SpecificationOptionService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

	@Autowired
	private SpecificationOptionMapper SpecificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SpecificationOption> findAll() {
		return SpecificationOptionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<SpecificationOption> page=   (Page<SpecificationOption>) SpecificationOptionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(SpecificationOption SpecificationOption) {
		SpecificationOptionMapper.insert(SpecificationOption);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(SpecificationOption SpecificationOption){
		SpecificationOptionMapper.updateByPrimaryKey(SpecificationOption);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SpecificationOption findOne(Long id){
		return SpecificationOptionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			SpecificationOptionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(SpecificationOption SpecificationOption, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SpecificationOptionExample example=new SpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		/*
		if(SpecificationOption!=null){			
						if(SpecificationOption.getSpecificationOptionName()!=null && SpecificationOption.getSpecificationOptionName().length()>0){
				criteria.andSpecificationOptionNameLike("%"+SpecificationOption.getSpecificationOptionName()+"%");
			}
	
		}*/
		
		Page<SpecificationOption> page= (Page<SpecificationOption>)SpecificationOptionMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
