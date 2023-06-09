package com.dream.school.transfer

import com.dream.school.dto.AreaDTO
import com.dream.school.vo.AreaVO

/**
 * 递归转换dto为vo
 */
fun convertDtoToVo(dtoNodes: List<AreaDTO>): List<AreaVO> {
    return dtoNodes.map { dtoNode ->
        AreaVO(
            code = dtoNode.code,
            name = dtoNode.name,
            parent = dtoNode.parent,
            child = dtoNode.child?.let { convertDtoToVo(it) }
        )
    }
}