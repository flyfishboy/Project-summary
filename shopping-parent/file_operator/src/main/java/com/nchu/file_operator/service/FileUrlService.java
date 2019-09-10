package com.nchu.file_operator.service;

import com.nchu.file_operator.model.FileUrl;

import java.util.List;

public interface FileUrlService {
    public Integer addFileUrl(FileUrl fileUrl);

    public List<FileUrl> getFileUrlsByName(String fileName);

    public FileUrl getFileUrlById(Integer id);

}
