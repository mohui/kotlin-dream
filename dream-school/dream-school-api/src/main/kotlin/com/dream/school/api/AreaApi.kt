package com.dream.school.api

import com.dream.school.vo.AreaVO
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

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
     * 上传图片
     */
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/area/uploadPicture"],
        produces = ["application/json"]
    )
    fun uploadPicture()
}