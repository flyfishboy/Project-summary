package com.nchu.security.service;

import com.nchu.security.dao.SysUserMapper;
import com.nchu.security.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService {
    @Resource
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
