package com.dream.school.api

import com.dream.school.vo.GradeVO
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.math.BigInteger
import javax.validation.Valid

@Validated
interface SchoolApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/school/grade"],
        produces = ["application/json"]
    )
    fun gradeList(): List<GradeVO>

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/school/grade"],
        produces = ["application/json"]
    )
    fun grade(): Map<String, Map<String, String>>

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
    fun list(@RequestBody id: BigInteger): String
}