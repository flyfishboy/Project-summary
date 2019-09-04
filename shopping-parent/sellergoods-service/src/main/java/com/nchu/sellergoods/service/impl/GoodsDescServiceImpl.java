package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.GoodsDescMapper;
import com.nchu.model.GoodsDesc;
import com.nchu.model.GoodsDescExample;
import com.nchu.model.GoodsDescExample.Criteria;
import com.nchu.sellergoods.service.GoodsDescService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {

	@Autowired
	private GoodsDescMapper GoodsDescMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<GoodsDesc> findAll() {
		return GoodsDescMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<GoodsDesc> page=   (Page<GoodsDesc>) GoodsDescMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(GoodsDesc GoodsDesc) {
		GoodsDescMapper.insert(GoodsDesc);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(GoodsDesc GoodsDesc){
		GoodsDescMapper.updateByPrimaryKey(GoodsDesc);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public GoodsDesc findOne(Long id){
		return GoodsDescMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			GoodsDescMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(GoodsDesc GoodsDesc, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		GoodsDescExample example=new GoodsDescExample();
		Criteria criteria = example.createCriteria();
		
		if(GoodsDesc!=null){			
						if(GoodsDesc.getIntroduction()!=null && GoodsDesc.getIntroduction().length()>0){
				criteria.andIntroductionLike("%"+GoodsDesc.getIntroduction()+"%");
			}
			if(GoodsDesc.getSpecificationItems()!=null && GoodsDesc.getSpecificationItems().length()>0){
				criteria.andSpecificationItemsLike("%"+GoodsDesc.getSpecificationItems()+"%");
			}
			if(GoodsDesc.getCustomAttributeItems()!=null && GoodsDesc.getCustomAttributeItems().length()>0){
				criteria.andCustomAttributeItemsLike("%"+GoodsDesc.getCustomAttributeItems()+"%");
			}
			if(GoodsDesc.getItemImages()!=null && GoodsDesc.getItemImages().length()>0){
				criteria.andItemImagesLike("%"+GoodsDesc.getItemImages()+"%");
			}
			if(GoodsDesc.getPackageList()!=null && GoodsDesc.getPackageList().length()>0){
				criteria.andPackageListLike("%"+GoodsDesc.getPackageList()+"%");
			}
			if(GoodsDesc.getSaleService()!=null && GoodsDesc.getSaleService().length()>0){
				criteria.andSaleServiceLike("%"+GoodsDesc.getSaleService()+"%");
			}
	
		}
		
		Page<GoodsDesc> page= (Page<GoodsDesc>)GoodsDescMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
