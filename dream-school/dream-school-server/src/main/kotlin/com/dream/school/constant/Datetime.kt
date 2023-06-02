package com.dream.school.constant

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * 当前时间
 */
val CURRENT_DATETIME = LocalDateTime.now()

/**
 * 当前年开始时间
 */
val CURRENT_YEAR_START_DATE = LocalDate.of(LocalDate.now().year, 1, 1).atStartOfDay()