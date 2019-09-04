package com.nchu.security.dao;

import com.nchu.security.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where id=#{id}")
    SysUser selectById(Integer id);
    @Select("select * from sys_user where name=#{name}")
    SysUser selectByName(String name);
}
