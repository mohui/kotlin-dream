package com.dream.school.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

interface UploadApi {
    /**
     * 上传图片,返回值为URL
     */
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/upload/uploadImageUrl"],
        produces = ["application/json"]
    )
    fun uploadImageUrl(@RequestParam("file") file: MultipartFile): ResponseEntity<String>
}