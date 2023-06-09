package com.dream.school.service

import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile

interface UploadService {
    /**
     * 上传图片, 返回URL
     */
    fun uploadImageUrl(file: MultipartFile): ResponseEntity<String>
}