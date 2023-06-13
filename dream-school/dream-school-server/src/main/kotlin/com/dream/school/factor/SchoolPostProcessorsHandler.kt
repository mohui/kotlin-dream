package com.dream.school.factor

interface SchoolPostProcessorsHandler {
    /**
     * 获取科目
     */
    fun execute(subject: String): List<String>

    /**
     * 获取科目code
     */
    fun support(subject: String): Boolean

    /**
     * 排序
     */
    fun getOrder(): Int
}