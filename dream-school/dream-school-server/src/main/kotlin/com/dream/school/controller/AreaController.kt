package com.dream.school.controller

import com.dream.school.api.AreaApi
import com.dream.school.constant.AREA
import com.dream.school.constant.AREA_DOT
import com.dream.school.service.AreaService
import com.dream.school.vo.AreaVO
import org.springframework.web.bind.annotation.RestController

@RestController("com.dream.school.api.AreaController")
class AreaController(
    val areaService: AreaService
): AreaApi {
    override fun list(): AreaVO {
        val areaDTO = areaService.areaRecursion(AREA_DOT)
        println("这是controller")
        println(areaDTO)
        return AREA
    }
}