package com.dream.school.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

interface ClassApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/class/list"],
        produces = ["application/json"]
    )
    fun list(): String
}