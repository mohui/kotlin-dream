package com.dream.school.service

import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile

/**
 * excel导出
 */
interface ExportService {
    fun exceptTest()

    /**
     * 导入Excel
     */
    fun importExcel()

    fun upload()

    fun handleFileUpload(file: MultipartFile): ResponseEntity<String>
}