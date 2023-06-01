package com.dream.school.service

import com.dream.school.vo.GradeVO

interface SchoolService {
    fun grade(): List<GradeVO>
}