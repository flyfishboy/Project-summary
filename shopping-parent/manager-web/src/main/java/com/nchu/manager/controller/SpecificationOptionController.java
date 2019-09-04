package com.nchu.manager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.nchu.model.SpecificationOption;
import com.nchu.sellergoods.service.SpecificationOptionService;

import com.nchu.model.PageResult;
import com.nchu.model.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/SpecificationOption")
public class SpecificationOptionController {

	@Reference
	private SpecificationOptionService SpecificationOptionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<SpecificationOption> findAll(){			
		return SpecificationOptionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return SpecificationOptionService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param SpecificationOption
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody SpecificationOption SpecificationOption){
		try {
			SpecificationOptionService.add(SpecificationOption);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param SpecificationOption
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SpecificationOption SpecificationOption){
		try {
			SpecificationOptionService.update(SpecificationOption);
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
	public SpecificationOption findOne(Long id){
		return SpecificationOptionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			SpecificationOptionService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody SpecificationOption SpecificationOption, int page, int rows  ){
		return SpecificationOptionService.findPage(SpecificationOption, page, rows);		
	}
	
}
