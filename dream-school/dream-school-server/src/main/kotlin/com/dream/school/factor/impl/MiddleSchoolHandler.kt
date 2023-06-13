package com.dream.school.factor.impl

import com.dream.school.factor.SchoolPostProcessorsHandler
import org.springframework.stereotype.Component

@Component
class MiddleSchoolHandler: SchoolPostProcessorsHandler {
    override fun execute(subject: String): List<String> {
        return listOf(
            "张明初一",
            "张明初二",
            "张明初三"
        )
    }

    /**
     * 如果是初中
     */
    override fun support(subject: String): Boolean {
        println("进来了初中里")
        return subject == "MIDDLE_SCHOOL"
    }

    override fun getOrder(): Int {
        return 2;
    }
}