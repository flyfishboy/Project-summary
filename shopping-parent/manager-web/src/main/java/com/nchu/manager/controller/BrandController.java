package com.nchu.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nchu.model.Brand;
import com.nchu.model.PageResult;
import com.nchu.model.Result;
import com.nchu.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        List<Brand> brandList=null;
        brandList=brandService.findAllBrand();
        return brandList;
    }

    @RequestMapping("/findPage")
    public PageResult<Brand> findPage(int page,int row){
        return brandService.findPage(page,row,null);
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand){
        Result result = null;
        try {
            Integer res=brandService.add(brand);
            if (res==0){
                result = new Result(false,"新增失败1");
            }else{
                result = new Result(true,"新增成功");
            }
        }catch (Exception e){
            result = new Result(false,"新增失败2");
        }
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand){
        Result result = null;
        try {
            Integer res=brandService.update(brand);
            if (res==0){
                result = new Result(false,"修改失败1");
            }else{
                result = new Result(true,"修改成功");
            }
        }catch (Exception e){
            result = new Result(false,"修改失败2");
        }
        return result;
    }

    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        Brand brand = null;
        try {
            brand = brandService.selectOne(id);
            if(brand == null) {
                brand = new Brand();
                brand.setId(-1L);
                brand.setName("没有id："+id+"的brand");
            }
        }catch (Exception e){
            brand = new Brand();
            brand.setId(-2L);
            brand.setName("失败2");
        }
        return brand;
    }

    @RequestMapping("/deleteOne")
    public Result deleteOne(Long id){
        Result result = null;
        try {
            Integer res=brandService.delete(id);
            if (res==0){
                result = new Result(false,"删除失败1");
            }else{
                result = new Result(true,"删除成功");
            }
        }catch (Exception e){
            result = new Result(false,"删除失败2");
        }
        return result;
    }

    @RequestMapping("/deleteMany")
    public Result deleteMany(Long[] ids){
        Result result = null;
        try {
            Integer res=brandService.delete(ids);
            if (res==ids.length){
                result = new Result(true,"删除成功");
            }else{
                result = new Result(false,"删除失败1");
            }
        }catch (Exception e){
            result = new Result(false,"删除失败2");
        }
        return result;
    }

    @RequestMapping("/findPageByEntity")
    public PageResult<Brand> findPageByEntity(Integer page,Integer row,@RequestBody Brand entityCondition){
        return brandService.findPage(page,row,entityCondition);
    }

}
