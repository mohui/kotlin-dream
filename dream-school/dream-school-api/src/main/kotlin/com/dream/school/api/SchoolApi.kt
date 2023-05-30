package com.dream.school.api

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.math.BigInteger
import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Validated
interface SchoolApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/school/add"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun add(@Valid id: BigInteger?): String
}