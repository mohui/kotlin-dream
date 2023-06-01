package com.dream.school.vo

import com.fasterxml.jackson.annotation.JsonProperty

enum class UserTypeEnum(val value: kotlin.String) {
    @JsonProperty("DRUG") DRUG("DRUG"),

    /**
     * 测血压
     */
    @JsonProperty("BLOOD_PRESSURE_MEASUREMENT") BLOOD_PRESSURE_MEASUREMENT("BLOOD_PRESSURE_MEASUREMENT"),
}