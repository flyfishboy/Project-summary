package com.nchu.sellergoods.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.PayLogMapper;
import com.nchu.model.PayLog;
import com.nchu.model.PayLogExample;
import com.nchu.model.PayLogExample.Criteria;
import com.nchu.sellergoods.service.PayLogService;

import com.nchu.model.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class PayLogServiceImpl implements PayLogService {

	@Autowired
	private PayLogMapper PayLogMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<PayLog> findAll() {
		return PayLogMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<PayLog> page=   (Page<PayLog>) PayLogMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(PayLog PayLog) {
		PayLogMapper.insert(PayLog);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(PayLog PayLog){
		PayLogMapper.updateByPrimaryKey(PayLog);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public PayLog findOne(String id){
		return PayLogMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			PayLogMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(PayLog PayLog, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		PayLogExample example=new PayLogExample();
		Criteria criteria = example.createCriteria();
		
		if(PayLog!=null){			
						if(PayLog.getOutTradeNo()!=null && PayLog.getOutTradeNo().length()>0){
				criteria.andOutTradeNoLike("%"+PayLog.getOutTradeNo()+"%");
			}
			if(PayLog.getUserId()!=null && PayLog.getUserId().length()>0){
				criteria.andUserIdLike("%"+PayLog.getUserId()+"%");
			}
			if(PayLog.getTransactionId()!=null && PayLog.getTransactionId().length()>0){
				criteria.andTransactionIdLike("%"+PayLog.getTransactionId()+"%");
			}
			if(PayLog.getTradeState()!=null && PayLog.getTradeState().length()>0){
				criteria.andTradeStateLike("%"+PayLog.getTradeState()+"%");
			}
			if(PayLog.getOrderList()!=null && PayLog.getOrderList().length()>0){
				criteria.andOrderListLike("%"+PayLog.getOrderList()+"%");
			}
			if(PayLog.getPayType()!=null && PayLog.getPayType().length()>0){
				criteria.andPayTypeLike("%"+PayLog.getPayType()+"%");
			}
	
		}
		
		Page<PayLog> page= (Page<PayLog>)PayLogMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
