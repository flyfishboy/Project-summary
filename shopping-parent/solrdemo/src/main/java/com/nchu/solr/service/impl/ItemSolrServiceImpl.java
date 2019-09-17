package com.nchu.solr.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nchu.mapper.ItemMapper;
import com.nchu.model.Item;
import com.nchu.solr.service.ItemSolrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemSolrServiceImpl implements ItemSolrService {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<Item> getAllItems() {
        return itemMapper.selectByExample(null);
    }

    @Override
    public Page<Item> getPageItems(Integer pageNo, Integer pageSize) {
        //启动分页
        PageHelper.startPage(pageNo,pageSize);
        //分页查询出数据
        Page<Item> itemPage=(Page<Item>) itemMapper.selectByExample(null);
        //返回分页显示结
        return itemPage;

    }
}
