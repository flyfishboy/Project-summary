package com.nchu.file_operator.dao;

import com.nchu.file_operator.model.FileUrl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileUrlDao {
        @Insert("insert into file_url(file_name,group_name,file_path) values(#{fileName},#{groupName},#{filePath})")
        public Integer insert (FileUrl fileUrl);
        @Select("select id,file_name fileName, group_name groupName,file_path filePath from file_url where file_name like '%#{fileName}%'")
        public List<FileUrl> findByName(String fileName);
        @Select("select id,file_name fileName, group_name groupName,file_path filePath from file_url where id=#{id}")
        public FileUrl selectOne(Integer id);

}
