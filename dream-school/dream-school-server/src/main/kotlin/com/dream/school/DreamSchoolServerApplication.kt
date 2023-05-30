package com.dream.school

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DreamSchoolServerApplication

fun main(args: Array<String>) {
    runApplication<DreamSchoolServerApplication>(*args)
}
