package com.dream.school.controller

import com.dream.school.api.SchoolApi
import com.dream.school.service.SchoolService
import com.dream.school.vo.GradeVO
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController("com.dream.school.api.SchoolController")
class SchoolController(
    val schoolService: SchoolService
): SchoolApi {
    override fun grade(): List<GradeVO> {
        return schoolService.grade()
    }

    override fun add(id: BigInteger): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }

    override fun list(id: BigInteger): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }


}