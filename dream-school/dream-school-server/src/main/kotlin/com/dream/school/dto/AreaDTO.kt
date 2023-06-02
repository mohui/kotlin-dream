package com.dream.school.dto

data class AreaDTO(
    /**
     * 地区编码
     */
    var code: String,
    var name: String,
    var path: String? = null,
    var level: String? = null,
    var childCount: Int? = null,
    var child: AreaDTO? = null
) {
}