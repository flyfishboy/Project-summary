package com.nchu.sellergoods.service.impl;
import java.util.List;

import com.nchu.mapper.SpecificationOptionMapper;
import com.nchu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.SpecificationMapper;
import com.nchu.sellergoods.service.SpecificationService;

import javax.annotation.Resource;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {
	@Resource
	SpecificationMapper specificationMapper;

	@Resource
	private SpecificationOptionMapper specificationOptionMapper;

	
	/**
	 * 查询全部
	 */
	@Override
	public List<Specification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */


	@Override
	public PageResult<Specification> findPage(int pageNum, int pageSize, Specification specification) {
		//启用分页
		PageHelper.startPage(pageNum, pageSize);
		//构建查询条件
		SpecificationExample example = null;
		if (specification != null) {
			example = new SpecificationExample();
			SpecificationExample.Criteria criteria = example.createCriteria();
			if (specification.getSpecName() != null && !specification.getSpecName().equals("")) {
				criteria.andSpecNameLike("%" + specification.getSpecName() + "%");
			}
		}
		//条件查询
		Page<Specification> Page = (Page<Specification>)specificationMapper.selectByExample(example);
		return new PageResult(Page.getTotal(),Page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		specificationMapper.insert(specification);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		specificationMapper.updateByPrimaryKey(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		//先从第一张表查
		Specification specification=specificationMapper.selectByPrimaryKey(id);
		//设置从表查询条件
		SpecificationOptionExample example = new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		//查询出数据
		List<SpecificationOption> options = specificationOptionMapper.selectByExample(example);
		if(options != null) {
			specification.setOptions(options);
		}
		return specification;
	}

	/**
	 * 删除单个
	 * @param id
	 */
	@Override
	public Integer delete(Long id){
		return specificationMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public Integer delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
		}
		return ids.length;
	}
	

	
}
