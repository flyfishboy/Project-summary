package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ItemCatMapper;
import com.nchu.model.ItemCat;
import com.nchu.model.ItemCatExample;
import com.nchu.model.ItemCatExample.Criteria;
import com.nchu.sellergoods.service.ItemCatService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper ItemCatMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ItemCat> findAll() {
		return ItemCatMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<ItemCat> page=   (Page<ItemCat>) ItemCatMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ItemCat ItemCat) {
		ItemCatMapper.insert(ItemCat);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ItemCat ItemCat){
		ItemCatMapper.updateByPrimaryKey(ItemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ItemCat findOne(Long id){
		return ItemCatMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			ItemCatMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(ItemCat ItemCat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ItemCatExample example=new ItemCatExample();
		Criteria criteria = example.createCriteria();
		
		if(ItemCat!=null){			
						if(ItemCat.getName()!=null && ItemCat.getName().length()>0){
				criteria.andNameLike("%"+ItemCat.getName()+"%");
			}
	
		}
		
		Page<ItemCat> page= (Page<ItemCat>)ItemCatMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
