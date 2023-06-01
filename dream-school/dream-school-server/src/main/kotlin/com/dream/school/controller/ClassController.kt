package com.dream.school.controller

import com.dream.school.api.ClassApi
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController("com.dream.school.api.ClassController")
class ClassController: ClassApi {
    override fun list(): String {
        return "班级列表"
    }
}