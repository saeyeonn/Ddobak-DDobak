package org.itm.ddobak.script

import org.itm.ddobak.classification.DifficultyLevel
import java.sql.Blob
import java.time.LocalDateTime

data class ScriptInfo(
    val id: Long,
    val title: String,
    val script: String,
    val translatedScript: String,
    val audioURL: String,
    val waveForm: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)