package com.dream.school.service.impl

import com.dream.school.service.SchoolService
import com.dream.school.vo.GradeVO
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SchoolServiceImpl():SchoolService {
    override fun grade(): List<GradeVO> {
        println("这是service里的")
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
}