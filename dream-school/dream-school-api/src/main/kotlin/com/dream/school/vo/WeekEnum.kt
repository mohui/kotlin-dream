package com.dream.school.vo

import com.fasterxml.jackson.annotation.JsonProperty

enum class WeekEnum(val value: kotlin.String) {
    /**
     * 周一
     */
    @JsonProperty("MONDAY") MONDAY("MONDAY"),

    /**
     * 周二
     */
    @JsonProperty("TUESDAY") TUESDAY("TUESDAY"),

    /**
     * 周三
     */
    @JsonProperty("WEDNESDAY") WEDNESDAY("WEDNESDAY"),

    /**
     * 周四
     */
    @JsonProperty("THURSDAY") THURSDAY("THURSDAY"),

    /**
     * 周五
     */
    @JsonProperty("FRIDAY") FRIDAY("FRIDAY"),

    /**
     * 周六
     */
    @JsonProperty("SATURDAY") SATURDAY("SATURDAY"),

    /**
     * 周日
     */
    @JsonProperty("SUNDAY") SUNDAY("SUNDAY")
}