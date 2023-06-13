package com.dream.school.factor

import org.springframework.stereotype.Component

@Component
class SchoolPostProcessorsHandlerFactory(
    schoolHandlerList: List<SchoolPostProcessorsHandler>
) {
    private val schoolList = schoolHandlerList.sortedByDescending { it.getOrder() }

    private fun getProcessorsHandlerStrategy(string: String): SchoolPostProcessorsHandler? {
        return schoolList.firstOrNull { it.support(string) }
    }

    fun execute(string: String): List<String> {
        return getProcessorsHandlerStrategy(string)?.execute(string) ?: listOf()
    }
}