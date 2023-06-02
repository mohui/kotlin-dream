package com.dream.school.service

import com.dream.school.dto.AreaDTO
import com.dream.school.vo.AreaVO

interface AreaService {
    /**
     * 地区递归
     */
    fun areaRecursion(areaDTO: AreaDTO): AreaDTO
}