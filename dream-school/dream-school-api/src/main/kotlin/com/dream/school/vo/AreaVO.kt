package com.dream.school.vo

data class AreaVO(
    /**
     * 地区编码
     */
    val code: String,
    val name: String,
    val parent: String? = null,
    val path: String? = null,
    val level: String? = null,
    val childCount: Int? = null,
    val child: List<AreaVO>? = null
) {
}