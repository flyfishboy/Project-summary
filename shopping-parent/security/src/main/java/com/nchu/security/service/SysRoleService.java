package com.nchu.security.service;

import com.nchu.security.dao.SysRoleMapper;
import com.nchu.security.model.SysRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleService {
    @Resource
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }

    public List<SysRole> listByUserId(Integer userId){
        return roleMapper.listByUserId(userId);
    }
}
