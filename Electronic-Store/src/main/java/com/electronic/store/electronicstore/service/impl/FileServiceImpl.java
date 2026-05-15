package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.exceptions.BadApiException;
import com.electronic.store.electronicstore.service.interfaces.FileService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadImage(MultipartFile file, String locationPath) {

        String orignalFileName = file.getOriginalFilename();
        logger.info("File name : {}",orignalFileName);

        String fileName = UUID.randomUUID().toString();
        String extension = orignalFileName.substring(orignalFileName.lastIndexOf("."));
        String fileNameWithExtension = fileName + extension;
        String fullPathWithFileName = locationPath + File.separator+ fileNameWithExtension;
        logger.info("File name with extension : {}",fileNameWithExtension);

        if(extension.equalsIgnoreCase(".png")|| extension.equalsIgnoreCase(".jpg")){
            try {
                File folder = new File(locationPath);
                if(!folder.exists()) {
                    folder.mkdirs();
                }
                Files.copy(file.getInputStream(), new File(fullPathWithFileName).toPath());
            }catch (Exception e){
                logger.error("Error while uploading file : {}",e.getMessage());
                throw new BadApiException("Error while uploading file");
                }
            return fileNameWithExtension;
        }
        else{
            throw new BadApiException("File with extension " +extension+ " not allowed");
        }

    }

    @Override
    public InputStream getResource(String locationPath, String fileName) {
        String fullPathWithFileName = locationPath + File.separator+ fileName;
        try {
            return Files.newInputStream(new File(fullPathWithFileName).toPath());
        }catch (Exception e){
            logger.error("Error while reading file : {}",e.getMessage());
            throw new BadApiException("Error while reading file");
        }
    }
}
