package com.nchu.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.BrandMapper;
import com.nchu.model.Brand;
import com.nchu.model.BrandExample;
import com.nchu.model.PageResult;
import com.nchu.sellergoods.service.BrandService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAllBrand() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult<Brand> findPage(int pageNum,int pageSize,Brand brand) {
        //启用分页
        PageHelper.startPage(pageNum, pageSize);
        //构建查询条件
        BrandExample example = null;
        if (brand != null) {
            example = new BrandExample();
            BrandExample.Criteria criteria = example.createCriteria();
            if (brand.getName() != null && !brand.getName().equals("")) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && !brand.getFirstChar().equals("")){
                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
        }
    }
        //条件查询
        Page<Brand> brandPage = (Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult(brandPage.getTotal(),brandPage.getResult());
    }

    @Override
    public Integer add(Brand brand){
        return brandMapper.insert(brand);
    }

    @Override
    public Integer update(Brand brand) {
        return brandMapper.updateByPrimaryKey(brand);
}
    @Override
    public Brand selectOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
    @Override
    public Integer delete(Long id){
        return brandMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Integer delete(Long[] ids){
        for(Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
        return ids.length;
    }

}
