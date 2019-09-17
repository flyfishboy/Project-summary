package com.nchu.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nchu.model.Item;
import com.nchu.search.service.ItemSearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {
    @Autowired
    private SolrTemplate solrTemplate;


    /**
     *  根据前端传过来的查询条件，返回查询结果
     * @param searchMap
     * @return
     * */
    @Override
    public Map<String, Object> search(Map searchMap) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("categories",getCategoryGroup(searchMap));

        resultMap.put("keywords",getItemList(searchMap));
        return resultMap;
    }

    private List<String> getCategoryGroup(Map searchMap){
        List<String> categoryList = null;
        //添加查询条件
        Query query = new SimpleQuery("*.*");
        //1.1添加输入的词
        if(searchMap.get("keywords")!=null&&!searchMap.get("keywords").equals("")){
            Criteria criteria = new Criteria("title").is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        }
        //1.2分组，设置分租
        GroupOptions options=new GroupOptions().addGroupByField("category");
        query.setGroupOptions(options);
        //1.3执行查询，得到所有分组
        GroupPage<Item> groupPage = solrTemplate.queryForGroupPage("testcore",query,Item.class);
        //1.4得到要用的分组
        GroupResult<Item> groupResult =groupPage.getGroupResult("category");
        //1.5获得分组对象入口
        Page<GroupEntry<Item>> groupEntries = groupResult.getGroupEntries();
        for(GroupEntry<Item> entry:groupEntries){
            String groupValue = entry.getGroupValue();
            if(groupValue!=null&&!groupValue.equals("")){
                categoryList.add(groupValue);
            }
        }
        return categoryList;
    }
    /**
     *   查询的具体实现方法
     * @param searchMap
     * @return
     * */
    private List<Item> getItemList(Map searchMap){
        Query query = new SimpleQuery("*:*");
        if(searchMap.get("keywords")!=null&&!searchMap.get("keywords").equals("")){
            Criteria criteria = new Criteria("title").is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        }
        ScoredPage<Item> scoredPage = solrTemplate.queryForPage("testcore",query,Item.class);
        List<Item> itemList = scoredPage.getContent();
        return itemList;
    }
}
