package com.dream.school.service.impl

import com.dream.school.constant.AREA_LIST
import com.dream.school.dto.AreaDTO
import com.dream.school.service.AreaService
import com.dream.school.vo.AreaVO
import org.springframework.stereotype.Service
import school.migrations.AreaTable

@Service
class AreaServiceImpl(
    val areaTable: AreaTable
): AreaService {
    companion object{
        // @Volatile 注解是多线程的时候互不影响
        @Volatile
        private var teep =  0
    }

    /**
     * 地区树形图
     */
    override fun areaTree(): List<AreaVO> {
        val areaList = areaTable.select().find()
            ?.map {
                AreaVO(
                    code = it.code,
                    name = it.name
                )
            }
        return areaList ?: listOf()
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

    /**
     * 找到所有子集
     */
    override fun areaChild() {
        val c = AREA_LIST.let { listIt->
            /**
             * associateBy: 会去重, 所有用主键ID
             * @return {code = AreaVO}
             */
            val areaListMap = listIt.map { mapIt->
                AreaDTO(
                    code = mapIt.code,
                    name = mapIt.name,
                    parent = mapIt.parent
                )
            }.associateBy { it.code }

            listIt.forEach {forEachIt->
                if (forEachIt.parent != null) {
                    areaListMap[forEachIt.parent]?.child = areaListMap[forEachIt.code]
                }
            }
            areaListMap
        }
        println(c)
    }
}