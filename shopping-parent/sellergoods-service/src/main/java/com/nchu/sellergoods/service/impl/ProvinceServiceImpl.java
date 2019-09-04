package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ProvinceMapper;
import com.nchu.model.Province;
import com.nchu.model.ProvinceExample;
import com.nchu.model.ProvinceExample.Criteria;
import com.nchu.sellergoods.service.ProvinceService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceMapper ProvinceMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Province> findAll() {
		return ProvinceMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Province> page=   (Page<Province>) ProvinceMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Province Province) {
		ProvinceMapper.insert(Province);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Province Province){
		ProvinceMapper.updateByPrimaryKey(Province);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Province findOne(Long id){
		return ProvinceMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			ProvinceMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Province Province, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ProvinceExample example=new ProvinceExample();
		Criteria criteria = example.createCriteria();
		
		if(Province!=null){			
						if(Province.getProvinceid()!=null && Province.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+Province.getProvinceid()+"%");
			}
			if(Province.getProvince()!=null && Province.getProvince().length()>0){
				criteria.andProvinceLike("%"+Province.getProvince()+"%");
			}
	
		}
		
		Page<Province> page= (Page<Province>)ProvinceMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
