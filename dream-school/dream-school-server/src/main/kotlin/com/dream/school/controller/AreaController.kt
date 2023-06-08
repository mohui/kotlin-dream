package com.dream.school.controller

import com.dream.school.api.AreaApi
import com.dream.school.dto.AreaDTO
import com.dream.school.service.AreaService
import com.dream.school.service.ExportService
import com.dream.school.vo.AreaVO
import org.springframework.web.bind.annotation.RestController

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
     * 递归转换dot为vo
     */
    private fun convertDtoToVo(dtoNodes: List<AreaDTO>): List<AreaVO> {
        return dtoNodes.map { dtoNode ->
            AreaVO(
                code = dtoNode.code,
                name = dtoNode.name,
                parent = dtoNode.parent,
                child = dtoNode.child?.let { convertDtoToVo(it) }
            )
        }
    }
}