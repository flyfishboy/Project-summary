package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.AreaMapper;
import com.nchu.model.Area;
import com.nchu.model.AreaExample;
import com.nchu.model.AreaExample.Criteria;
import com.nchu.sellergoods.service.AreaService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper AreaMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Area> findAll() {
		return AreaMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Area> page=   (Page<Area>) AreaMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Area Area) {
		AreaMapper.insert(Area);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Area Area){
		AreaMapper.updateByPrimaryKey(Area);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Area findOne(Long id){
		return AreaMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			AreaMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Area Area, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		AreaExample example=new AreaExample();
		Criteria criteria = example.createCriteria();
		
		if(Area!=null){			
						if(Area.getAreaid()!=null && Area.getAreaid().length()>0){
				criteria.andAreaidLike("%"+Area.getAreaid()+"%");
			}
			if(Area.getArea()!=null && Area.getArea().length()>0){
				criteria.andAreaLike("%"+Area.getArea()+"%");
			}
			if(Area.getCityid()!=null && Area.getCityid().length()>0){
				criteria.andCityidLike("%"+Area.getCityid()+"%");
			}
	
		}
		
		Page<Area> page= (Page<Area>)AreaMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
