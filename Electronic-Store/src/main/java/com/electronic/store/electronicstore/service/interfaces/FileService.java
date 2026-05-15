package com.electronic.store.electronicstore.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {

    String uploadImage(MultipartFile fileName, String locationPath);

    InputStream getResource(String locationPath, String fileName);
}
