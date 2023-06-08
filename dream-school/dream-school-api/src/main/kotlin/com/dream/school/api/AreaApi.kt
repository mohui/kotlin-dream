package com.dream.school.api

import com.dream.school.vo.AreaVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

interface AreaApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/list"],
        produces = ["application/json"]
    )
    fun list(): List<AreaVO>

    /**
     * 导出Excel
     */
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/exportExcel"],
        produces = ["application/json"]
    )
    fun exportExcel()

    /**
     * 导入Excel
     */
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/importExcel"],
        produces = ["application/json"]
    )
    fun importExcel()

    /**
     * 上传图片
     */
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/uploadPicture"],
        produces = ["application/json"]
    )
    fun uploadPicture()

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/handleFileUpload"],
        produces = ["application/json"]
    )
    fun handleFileUpload(@RequestParam("file") file: MultipartFile): ResponseEntity<String>

}