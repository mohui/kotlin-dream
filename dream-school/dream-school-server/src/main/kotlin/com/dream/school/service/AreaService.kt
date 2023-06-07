package com.dream.school.service

import com.dream.school.dto.AreaDTO
import com.dream.school.vo.AreaVO

interface AreaService {
    /**
     * 树形图
     */
    fun areaTree(): List<AreaVO>
    /**
     * 地区递归
     */
    fun areaRecursion(areaDTO: AreaDTO): AreaDTO

    fun areaChild()
}