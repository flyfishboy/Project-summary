package com.nchu.sellergoods.service;
import java.util.List;
import com.nchu.model.Area;

import com.nchu.model.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AreaService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Area> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Area Area);
	
	
	/**
	 * 修改
	 */
	public void update(Area Area);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Area findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Area Area, int pageNum, int pageSize);
	
}
