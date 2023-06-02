package com.dream.school.service

import com.dream.school.dto.CalculationCycleDTO
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

interface DatetimeService {
    fun calculationCycle(
        chronoNum: Int,
        chronoUnit: ChronoUnit,
        startDateTime: LocalDateTime,
        now: LocalDateTime = LocalDateTime.now()
    ): CalculationCycleDTO
}