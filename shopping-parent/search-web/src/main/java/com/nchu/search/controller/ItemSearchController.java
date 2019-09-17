package com.nchu.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nchu.search.service.ItemSearchService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemSearchController {
    @Reference
    private ItemSearchService itemSearchService;
    @RequestMapping("search")
    public Map<String,Object> search(@RequestBody Map searchMap) {
        Map<String,Object> resultMap = new HashMap<>();
        System.out.println(searchMap);
        resultMap=itemSearchService.search(searchMap);
        return resultMap;
    }
}
