package com.nchu.file_operator.model;

import java.io.Serializable;

public class FileUrl implements Serializable {
    private Integer id;
    private String fileName;
    private String groupName;
    private String filePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileUrl{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
