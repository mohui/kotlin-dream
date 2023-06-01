package com.dream.school.vo

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid

/**
 * 年级
 */
data class GradeVO(
    @field:Valid
    @field:JsonProperty("code", required = true) val code: String,

    @field:JsonProperty("name", required = true) val name: kotlin.String,

    @field:JsonProperty("isDel", required = true) val isDel: kotlin.Boolean,

    @field:JsonProperty("createdAt") val createdAt: java.time.LocalDateTime? = null
) {
}