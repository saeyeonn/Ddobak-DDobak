package org.itm.ddobak.user.review

import org.itm.ddobak.admin.DifficultyLevel
import java.time.LocalDateTime

data class ReviewScriptInfo(
    val id: Long,
    val languageId: Long,
    val categoryId: Long,
    val difficultyLevel: DifficultyLevel,
    val title: String,
    val userTrial: Int,
    val userAverageAccuracy: Double,
    val userAverageFluency: Double,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)
