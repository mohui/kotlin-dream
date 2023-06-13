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

        // 获取项目根目录的绝对路径(用不到)
        val projectDir = System.getProperty("user.dir")

        val url = "${projectDir}/dream-school/dream-school-server/src/upload/"

        try {
            val destFile = File(url, fileName)
            file.transferTo(destFile)
            val fileUrl = destFile.toURI().toString()
            return ResponseEntity.ok(fileUrl)
        } catch (e: IOException) {
            e.printStackTrace()
            return ResponseEntity.status(500).build()
        }
    }
}