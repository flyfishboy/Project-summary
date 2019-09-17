package com.nchu.solr;

import com.nchu.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrdemoApplicationTests {

    @Autowired
    private SolrTemplate solrTemplate;
    @Test
    public void addItem() {
        Item item = new Item();
        item.setId(536564L);
        item.setTitle("new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待");
        item.setSellPoint("下单送12000毫安移动电源！双3.5英寸魔焕炫屏，以非凡视野纵观天下时局，尊崇翻盖设计，张弛中，尽显从容气度！");
        item.setCategory("手机");
        item.setSpec("{\"机身内存\":\"16G\",\"网络\":\"联通3G\"}");
        item.setSeller("阿尔卡特");
        solrTemplate.saveBean("testcore",item);
        solrTemplate.commit("testcore");
    }

    @Test
    public void addItem10000() {
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        for (int i=0;i<2001;i++) {
            item.setId(2000+i+536564L);
            item.setTitle("夏普（SHARP）LCD-46DS40A 46英寸 日本原装液晶面板 智能全高清液晶电视");
            item.setSellPoint("要好屏，选夏普！日本原装面板，智能电视，高画质高音质！<a  target=\"blank\"  href=\"http://item.jd.com/1278686.html\">还有升级版安卓智能新机46DS52供您选择！</a>");
            item.setCategory("平板电视");
            item.setBrand("夏普");
            item.setSpec("{\"电视屏幕尺寸\":\"46英寸\"}");
            item.setSeller("夏普");
            solrTemplate.saveBean("testcore", item);

        }
        solrTemplate.commit("testcore");
    }
    @Test
    public void deleteItemById(){
        solrTemplate.deleteByIds("testcore", "537565");
        solrTemplate.commit("testcore");
    }

    @Test
    public void query(){
        List<Item> itemList = null;
        Query query = new SimpleQuery();
        Criteria criteria = new Criteria("title").contains("联通");
        query.addCriteria(criteria);
        query.setOffset(20L);
        query.setRows(5);
        ScoredPage<Item> page = solrTemplate.query("testcore",query,Item.class);
        System.out.println(page.getContent().toString());
    }

    @Test
    public void queryHighLight(){
        HighlightQuery query = new SimpleHighlightQuery();
        HighlightOptions options = new HighlightOptions().addField("item_title");
        options.setSimplePrefix("<em style='color:red'>");
        options.setSimplePostfix("</em>");
        query.setHighlightOptions(options);
        Criteria criteria = new Criteria("title").contains("联通");
        query.addCriteria(criteria);
        query.setOffset(20L);
        query.setRows(1);
        HighlightPage<Item> page = solrTemplate.queryForHighlightPage("testcore",query,Item.class);
        List<HighlightEntry<Item>> highlighted = page.getHighlighted();

        System.out.println(page.getContent().toString());
    }

    @Test
    public void testDeleteAll() {
        Query query = new SimpleQuery("*.*");
        solrTemplate.delete("testcore",query);
        solrTemplate.commit("testcore");

    }
}
