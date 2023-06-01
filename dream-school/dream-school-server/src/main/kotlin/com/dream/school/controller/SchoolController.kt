package com.dream.school.controller

import com.dream.school.api.SchoolApi
import com.dream.school.vo.GradeVO
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import java.time.LocalDateTime

@RestController("com.dream.school.api.SchoolController")
class SchoolController: SchoolApi {
    override fun grade(): List<GradeVO> {
        val list = mutableListOf<GradeVO>()
        val grade = GradeVO(
            code = "firstGrade",
            name = "一年级",
            isDel = false,
            createdAt = LocalDateTime.now()
        )
        list.add(grade)

        return list
    }

    override fun add(id: BigInteger): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }

    override fun list(id: BigInteger?): String {
        println("${id}这个是参数")
        return "hello word${id}的参数"
    }


}