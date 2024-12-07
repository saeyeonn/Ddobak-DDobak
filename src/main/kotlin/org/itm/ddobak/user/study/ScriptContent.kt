package org.itm.ddobak.user.study

import java.time.LocalDateTime

data class ScriptContent(
    val id: Long,
    val title: String,
    val script: String,
    val translatedScript: String,
    val userAverageAccuracy: Double,
    val userAverageFluency: Double,
    val isLast: Boolean
)