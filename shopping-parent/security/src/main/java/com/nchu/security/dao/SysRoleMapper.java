package com.nchu.security.dao;

import com.nchu.security.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE (select role_id from sys_user_role where user_id = #{userId})")
    List<SysRole> listByUserId(Integer userId);

    @Select("select * from sys_role where id=#{id}")
    SysRole selectById(Integer id);
}
