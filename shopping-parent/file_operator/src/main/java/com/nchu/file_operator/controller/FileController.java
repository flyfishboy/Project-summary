package com.nchu.file_operator.controller;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.nchu.file_operator.model.FileUrl;
import com.nchu.file_operator.service.FileUrlService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class FileController {
    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FileUrlService fileUrlService;
    @ResponseBody
    @PostMapping("/up")
    public String upload(@RequestParam("myFile") MultipartFile myFile) throws IOException {
        //获取文件后缀名
        String extension = FilenameUtils.getExtension(myFile.getOriginalFilename());
        //将要上传的文件存入FastDFS
        StorePath sp=storageClient.uploadFile("group1",myFile.getInputStream(),myFile.getSize(),extension);
        //将该文件的存入fastDFS的group组号，文件名，文件路径存入数据库
        FileUrl fileUrl=new FileUrl();
        fileUrl.setGroupName(sp.getGroup());
        fileUrl.setFileName(myFile.getName());
        fileUrl.setFilePath(sp.getPath());
        fileUrlService.addFileUrl(fileUrl);
        System.out.println(fileUrl);
        System.out.println(sp.getFullPath());
        return sp.getFullPath();

    }

    @GetMapping("/dows/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse re) throws IOException {
        FileUrl fileUrl=fileUrlService.getFileUrlById(id);
        String fileName= URLEncoder.encode(fileUrl.getFileName(),"UTF-8");
        String groupName=fileUrl.getGroupName();
        String pathName=fileUrl.getFilePath();
        //告诉浏览器下载的文件名
        re.setHeader("Content-Disposition","attachment; filename="+fileName+"");
        //去linux下载对应的文件
        byte[] bytes = storageClient.downloadFile(groupName, pathName);
        re.getOutputStream().write(bytes);

    }

}
