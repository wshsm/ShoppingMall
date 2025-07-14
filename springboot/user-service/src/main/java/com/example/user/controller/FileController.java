package com.example.user.controller;

import com.example.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {

    @PostMapping("/files/upload")
    public Result upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String uuid = UUID.randomUUID().toString();
        String fileUUID = uuid + "." + type;
        File uploadDir = new File("files");
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        File dest = new File(uploadDir.getAbsolutePath() + "/" + fileUUID);
        file.transferTo(dest);
        // 返回相对路径
        return Result.success("/files/" + fileUUID);
    }

    // 支持/api/files/{fileUUID} 兼容前端代理
    @GetMapping({"/files/{fileUUID}", "/api/files/{fileUUID}"})
    public void download(@PathVariable String fileUUID, javax.servlet.http.HttpServletResponse response) throws IOException {
        File uploadDir = new File("files");
        File file = new File(uploadDir.getAbsolutePath() + "/" + fileUUID);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileUUID);
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.io.OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            fileInputStream.close();
            outputStream.close();
        }
    }
} 