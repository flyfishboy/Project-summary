package com.nchu.portal.controller;

import com.nchu.search.service.ItemSearchService;
import jdk.nashorn.internal.ir.annotations.Reference;
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
    public Map<String,Object> search(@RequestBody String searchMap){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> smap = new HashMap<>();
        smap.put("keywords",searchMap);
        resultMap = itemSearchService.search(smap);
        return resultMap;
    }
}
