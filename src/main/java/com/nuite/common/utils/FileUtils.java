package com.nuite.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static String getWebAppsPath() {
        String filePath = System.getProperty("catalina.home");
        return filePath + File.separator + "webapps" + File.separator;
    }

    /**
     * 上传文件，返回文件名
     *
     * @param imgDir
     * @param img
     * @return
     * @throws IOException
     */
    public static String upLoadFile(String imgDir, String fileName, MultipartFile img) throws IOException {

        // 存放目录
        File fileDir = new File(imgDir);
        // 如果目录不存在就创建
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        // 原文件名
        String originalFilename = img.getOriginalFilename();
        originalFilename = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        if (fileName == null) {
            // 重新定义文件名
            fileName = UUID.randomUUID().toString().replaceAll("-", "_") + originalFilename;
        }
        logger.info("fileName:" + fileName);
        // 上传文件
        File file = new File(fileDir, fileName);
        file.createNewFile();
        img.transferTo(file);
        logger.info("AbsolutePath:" + file.getAbsolutePath());

        return fileName;
    }
}
