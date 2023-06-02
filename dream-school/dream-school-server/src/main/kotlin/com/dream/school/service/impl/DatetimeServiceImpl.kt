package com.dream.school.service.impl

import com.dream.school.dto.CalculationCycleDTO
import com.dream.school.service.DatetimeService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
class DatetimeServiceImpl(): DatetimeService {
    /**
     * @param chronoNum 频率, 比如两周1次 传值2
     * @param chronoUnit 频率时间 比如两周1次 传值周WEEKS
     * @param startDateTime 频率开始时间
     * @param now 当前时间
     */
    override fun calculationCycle(
        chronoNum: Int,
        chronoUnit: ChronoUnit,
        startDateTime: LocalDateTime,
        now: LocalDateTime
    ): CalculationCycleDTO {
        // 定义开始时间, 结束时间
        val start: LocalDateTime
        val end: LocalDateTime

        val between: Long = chronoUnit.between(startDateTime, now) / chronoNum

        if (between <= 0) {
            start = startDateTime
            end = chronoUnit.addTo(startDateTime, chronoNum.toLong())
        } else {
            val temp = chronoUnit.addTo(startDateTime, between * chronoNum)
            if (temp.isAfter(now)) {
                start = chronoUnit.addTo(startDateTime, between * chronoNum - chronoNum)
                end = temp
            } else {
                start = temp
                end = chronoUnit.addTo(startDateTime, between * chronoNum + chronoNum)
            }
        }

        return CalculationCycleDTO(
            start = start,
            end = end,
            between = between
        )
    }
}