package com.dream.school.api

import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.math.BigInteger
import javax.validation.Valid

@Validated
interface SchoolApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/school/add"],
        produces = ["application/json"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE]
    )
    fun add(@Valid id: BigInteger): String

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/school/list"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun list(@Valid id: BigInteger?): String
}