package com.dream.school.controller

import com.dream.school.api.AreaApi
import com.dream.school.service.AreaService
import com.dream.school.service.ExportService
import com.dream.school.transfer.convertDtoToVo
import com.dream.school.vo.AreaVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController("com.dream.school.api.AreaController")
class AreaController(
    val areaService: AreaService,
    val exportService: ExportService
): AreaApi {
    override fun list(): List<AreaVO> {
        val areaDtoList = areaService.areaTree()
        return convertDtoToVo(areaDtoList)
    }

    override fun exportExcel() {
        exportService.exceptTest()
    }

    /**
     * 导入Excel
     */
    override fun importExcel() {
        exportService.importExcel()
    }

    override fun uploadPicture() {
        exportService.upload()
    }

    /**
     * 上传文件
     */
    override fun handleFileUpload(file: MultipartFile): ResponseEntity<String> {
        return exportService.handleFileUpload(file)
    }

    /**
     * 上传文件,输出buffer
     */
    override fun uploadImageBuffer(file: MultipartFile): ResponseEntity<ByteArray> {
        return exportService.uploadImage(file)
    }
}