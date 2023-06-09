package com.dream.school.service.impl

import com.dream.school.service.UploadService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException

@Service
class UploadServiceImpl: UploadService {
    /**
     * 上传图片, 返回URL
     */
    override fun uploadImageUrl(file: MultipartFile): ResponseEntity<String> {
        val fileName = StringUtils.cleanPath(file.originalFilename ?: "")
        println(fileName)

        val url = "/Users/wanghehui/projects/xzmProjects/kotlin-dream/dream-school/dream-school-server/src/upload/"

        try {
            val destFile = File(url, fileName)
            file.transferTo(destFile)
            val fileUrl = destFile.toURI().toString()
            println(fileUrl)
            return ResponseEntity.ok(fileUrl)
        } catch (e: IOException) {
            e.printStackTrace()
            return ResponseEntity.status(500).build()
        }
    }
}