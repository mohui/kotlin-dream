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
    fun list(): AreaVO
}