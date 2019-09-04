package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.GoodsMapper;
import com.nchu.model.Goods;
import com.nchu.model.GoodsExample;
import com.nchu.model.GoodsExample.Criteria;
import com.nchu.sellergoods.service.GoodsService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Goods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Goods> page=   (Page<Goods>) goodsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		goodsMapper.insert(goods);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods){
		goodsMapper.updateByPrimaryKey(goods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Long id){
		return goodsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			goodsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Goods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		GoodsExample example=new GoodsExample();
		Criteria criteria = example.createCriteria();
		
		if(goods!=null){			
						if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
			if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
				criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
			}
			if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+goods.getSellerId()+"%");
			}
			if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
				criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
			}
			/*
			if(goods.getIntroduction()!=null && goods.getIntroduction().length()>0){
				criteria.andIntroductionLike("%"+goods.getIntroduction()+"%");
			}
			*/
	
		}
		
		Page<Goods> page= (Page<Goods>)goodsMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
