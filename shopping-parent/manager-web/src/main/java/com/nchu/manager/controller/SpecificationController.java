package com.nchu.manager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.nchu.model.Specification;
import com.nchu.sellergoods.service.SpecificationService;

import com.nchu.model.PageResult;
import com.nchu.model.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Specification> findAll(){			
		return specificationService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows){
		return specificationService.findPage(page, rows,null);
	}
	
	/**
	 * 增加
	 * @param specification
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Specification specification){
		try {
			specificationService.add(specification);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param specification
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Specification specification){
		try {
			specificationService.update(specification);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Specification findOne(Long id){
		return specificationService.findOne(id);		
	}

	@RequestMapping("/deleteOne")
	public Result deleteOne(Long id){
		Result result = null;
		try {
			Integer res=specificationService.delete(id);
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
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */

	@RequestMapping("/deleteMany")
	public Result deleteMany(Long[] ids){
		Result result = null;
		try {
			Integer res=specificationService.delete(ids);
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
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/findPageByEntity")
	public PageResult<Specification> findPageByEntity(Integer page, Integer rows,@RequestBody Specification entityCondition ){
		return specificationService.findPage(page, rows,entityCondition);
	}


}
