package com.nchu.solr.controller;

import com.github.pagehelper.Page;
import com.nchu.model.Item;
import com.nchu.model.Result;
import com.nchu.solr.service.ItemSolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SolrInitialController {
    @Resource
    private ItemSolrService itemSolrService;
    @Autowired
    private SolrTemplate solrTemplate;
    /*@RequestMapping("/initSolrxxx")
    public Result initSolr(){
        Result result=null;
        try {
            List<Item> itemList = itemSolrService.getAllItems();
            int i = 0;
            for (Item item : itemList) {
                i++;
                solrTemplate.saveBean("testcore", item);
                if (i == 100) {
                    i = 0;
                    solrTemplate.commit("testcore");
                }
            }
            solrTemplate.commit("testcore");
            result=new Result(true,"solr初始化成功！！！");
        }catch (Exception e){
            result=new Result(false,"solr初始化失败！！！");
        }finally {
            return result;
        }
    }*/

    @RequestMapping("/initSolr")
    @ResponseBody
    public Result initSolr2(){
        Result result=null;
        try {
            int i=0;
            Long total=100L;
            Page<Item> items=null;
            while(i<total){
                items=itemSolrService.getPageItems(0,100);
                i+=100;
                total=items.getTotal();
                List<Item> itemList = items.getResult();
                for (Item item : itemList) {
                    solrTemplate.saveBean("testcore", item);

                }
                solrTemplate.commit("testcore");
            }
            result=new Result(true,"solr初始化成功！！！");
        }catch (Exception e){
            e.printStackTrace();
            result=new Result(false,"solr初始化失败！！！");
        }finally {
            return result;
        }
    }
}
