package com.dream.school.controller

import com.dream.school.api.SchoolApi
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController("com.dream.school.api.SchoolController")
class SchoolController: SchoolApi {
    override fun add(id: BigInteger): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }

    override fun list(id: BigInteger?): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }
}