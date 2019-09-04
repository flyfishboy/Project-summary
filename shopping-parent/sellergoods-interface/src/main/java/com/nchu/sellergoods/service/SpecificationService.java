package com.nchu.sellergoods.service;
import java.util.List;

import com.nchu.model.Brand;
import com.nchu.model.Specification;

import com.nchu.model.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Specification> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	//public PageResult findPage(int pageNum, int pageSize);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult<Specification> findPage(int pageNum, int pageSize,Specification specification);
	
	/**
	 * 增加
	*/
	public void add(Specification specification);
	
	
	/**
	 * 修改
	 */
	public void update(Specification specification);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Specification findOne(Long id);

	public Integer delete(Long id);
	/**
	 * 批量删除
	 * @param ids
	 */
	public Integer delete(Long[] ids);




	
}
