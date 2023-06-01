package com.dream.school.vo

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import javax.validation.Valid

data class UserVO(
    @field:Valid
    @field:JsonProperty("patientId", required = true) val patientId: BigInteger,

    @field:JsonProperty("drugName", required = true) val drugName: kotlin.String,

    @field:JsonProperty("isUsed", required = true) val isUsed: kotlin.Boolean,

    @field:Valid
    @field:JsonProperty("time", required = true) val time: java.time.LocalTime,

    @field:Valid
    @field:JsonProperty("type", required = true) val type: UserTypeEnum,

    @field:Valid
    @field:JsonProperty("frequencys", required = true) val frequencys: kotlin.collections.List<WeekEnum>,

    @field:JsonProperty("cycleStartTime", required = true) val cycleStartTime: java.time.LocalDateTime,

    @field:JsonProperty("subName") val subName: kotlin.String? = null,

    @field:JsonProperty("cycleEndTime") val cycleEndTime: java.time.LocalDateTime? = null
) {
}