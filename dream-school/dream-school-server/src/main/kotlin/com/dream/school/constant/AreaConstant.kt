package com.dream.school.constant

import com.dream.school.dto.AreaDTO
import com.dream.school.vo.AreaVO

val AREA_LIST = listOf<AreaVO>(
    AreaVO(
        code = "34",
        name = "安徽省"
    ),
    AreaVO(
        code = "3402",
        name = "芜湖市",
        parent = "34"
    ),
    AreaVO(
        code = "3403",
        name = "芜湖市",
        parent = "34"
    ),
    AreaVO(
        code = "340202",
        name = "镜湖区",
        parent = "34"
    ),
    AreaVO(
        code = "340203",
        name = "弋江区",
        parent = "3402"
    ),
    AreaVO(
        code = "340208",
        name = "三山区",
        parent = "3402"
    )
)

/**
 * 当前时间
 */
val AREA = AreaVO(
    code = "34",
    name = "安徽省",
    child = listOf(
        AreaVO(
            code = "3402",
            name = "芜湖市",
            child = listOf(
                AreaVO(
                    code = "340202",
                    name = "镜湖区",
                    child = listOf(
                        AreaVO(
                            code = "340202001",
                            name = "镜湖区街道社区1",
                        ),
                        AreaVO(
                            code = "340202002",
                            name = "镜湖区街道社区2",
                        ),
                        AreaVO(
                            code = "340202003",
                            name = "镜湖区街道社区3",
                        )
                    )
                ),
                AreaVO(
                    code = "340203",
                    name = "弋江区",
                    child = listOf(
                        AreaVO(
                            code = "340203001",
                            name = "弋江区街道社区1",
                        ),
                        AreaVO(
                            code = "340203002",
                            name = "弋江区街道社区2",
                        )
                    )
                )
            )
        )
    )
)

val AREA_DOT = AreaDTO(
    code = "34",
    name = "安徽省",
    child = AreaDTO(
        code = "3402",
        name = "芜湖市",
        child = AreaDTO(
            code = "340203",
            name = "弋江区",
            child = AreaDTO(
                code = "340203001",
                name = "弋江区街道社区1",
            )
        )
    )
)