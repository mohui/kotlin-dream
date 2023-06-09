package com.dream.school.controller

import com.dream.school.api.UploadApi
import com.dream.school.service.UploadService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController("com.dream.school.api.UploadController")
class UploadController(
    val uploadService: UploadService
): UploadApi {
    /**
     * 上传图片, 返回值为URL
     */
    override fun uploadImageUrl(file: MultipartFile): ResponseEntity<String> {
        return uploadService.uploadImageUrl(file)
    }
}