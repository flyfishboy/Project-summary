package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.CityMapper;
import com.nchu.model.City;
import com.nchu.model.CityExample;
import com.nchu.model.CityExample.Criteria;
import com.nchu.sellergoods.service.CityService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper CityMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<City> findAll() {
		return CityMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<City> page=   (Page<City>) CityMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(City City) {
		CityMapper.insert(City);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(City City){
		CityMapper.updateByPrimaryKey(City);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public City findOne(Long id){
		return CityMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			CityMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(City City, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		CityExample example=new CityExample();
		Criteria criteria = example.createCriteria();
		
		if(City!=null){			
						if(City.getCityid()!=null && City.getCityid().length()>0){
				criteria.andCityidLike("%"+City.getCityid()+"%");
			}
			if(City.getCity()!=null && City.getCity().length()>0){
				criteria.andCityLike("%"+City.getCity()+"%");
			}
			if(City.getProvinceid()!=null && City.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+City.getProvinceid()+"%");
			}
	
		}
		
		Page<City> page= (Page<City>)CityMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
