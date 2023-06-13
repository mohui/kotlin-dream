package com.dream.school.factor.impl

import com.dream.school.factor.SchoolPostProcessorsHandler
import org.springframework.stereotype.Component

@Component
class PrimarySchoolGradeHandler: SchoolPostProcessorsHandler {
    override fun execute(subject: String): List<String> {
        return listOf(
            "西张明中心小学一年级",
            "西张明中心小学二年级",
            "西张明中心小学三年级"
        )
    }

    override fun support(subject: String): Boolean {

        println("进来了小学")
        // 判断是否是小学
        return subject == "PRIMARY_SCHOOL"
    }

    override fun getOrder(): Int {
        return 1
    }
}