package com.dream.school.dto

data class CalculationCycleDTO(
    val start: java.time.LocalDateTime,
    val end: java.time.LocalDateTime,
    val between: kotlin.Long
) {

}