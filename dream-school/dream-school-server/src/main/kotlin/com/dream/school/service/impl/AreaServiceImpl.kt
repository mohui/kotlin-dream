package com.dream.school.service.impl

import com.dream.school.dto.AreaDTO
import com.dream.school.service.AreaService
import org.springframework.stereotype.Service

@Service
class AreaServiceImpl: AreaService {
    companion object{
        // @Volatile 注解是多线程的时候互不影响
        @Volatile
        private var teep =  0
    }
    /**
     * 给path补充值
     */
    override fun areaRecursion(
        areaDTO: AreaDTO
    ): AreaDTO {
        teep++
        println("------外次--------")
        areaDTO.child?.let {
            areaRecursion(it)
        }
        val teepName = when(teep){
            1-> "最大的省"
            2-> "嘎嘎市"
            3-> "第三区"
            4-> "小街道"
            else-> "不知所谓"
        }
        areaDTO.level = teepName
        println("------内次--------")
        teep--
        return areaDTO
    }
}