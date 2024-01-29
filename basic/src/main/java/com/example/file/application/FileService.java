package com.example.file.application;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * post 썸네일 이미지 저장
     * @param path
     * @param file
     */
    String saveThumbnailImage(String path, MultipartFile file) throws Exception;
}
