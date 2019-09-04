package com.nchu.sellergoods.service;

import com.nchu.model.Brand;
import com.nchu.model.PageResult;
import com.nchu.model.Result;

import java.util.List;

public interface BrandService {
    /*
    * 查询所有的Brand
     */
    public List<Brand> findAllBrand();

    /*
     *分页查询brand
     *
     */

    public PageResult<Brand> findPage(int pageNum,int pageSize,Brand brand);

    /*
     *新增beand方法
     */
    public Integer add(Brand brand);

    /**
     *更改brand方法
     * @param
     * @return
     */
    public Integer update(Brand brand);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Brand selectOne(Long id);

    /**
     * 根据ID删除一个brand
     * @param id
     * @return
     */
    public Integer delete(Long id);

    /**
     * 删除多个ID的brand
     * @param ids
     * @return
     */
    public Integer delete(Long[] ids);
}
