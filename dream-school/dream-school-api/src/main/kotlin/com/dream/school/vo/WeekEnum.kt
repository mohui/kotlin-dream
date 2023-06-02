package com.dream.school.vo

import com.fasterxml.jackson.annotation.JsonProperty

enum class WeekEnum(val value: kotlin.String) {
    /**
     * 周一
     */
    @JsonProperty("MONDAY") MONDAY("星期一"),

    /**
     * 周二
     */
    @JsonProperty("TUESDAY") TUESDAY("星期二"),

    /**
     * 周三
     */
    @JsonProperty("WEDNESDAY") WEDNESDAY("星期三"),

    /**
     * 周四
     */
    @JsonProperty("THURSDAY") THURSDAY("星期四"),

    /**
     * 周五
     */
    @JsonProperty("FRIDAY") FRIDAY("星期五"),

    /**
     * 周六
     */
    @JsonProperty("SATURDAY") SATURDAY("星期六"),

    /**
     * 周日
     */
    @JsonProperty("SUNDAY") SUNDAY("星期日")
}