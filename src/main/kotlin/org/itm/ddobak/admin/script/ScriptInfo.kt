package org.itm.ddobak.admin.script

import java.time.LocalDateTime

data class ScriptInfo(
    val id: Long,
    val title: String,
    val script: String,
    val translatedScript: String,
    val audioURL: String,
    val waveForm: List<Float>,
    val userAverageAccuracy: Double,
    val userAverageFluency: Double,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)