package org.itm.ddobak.user.study

import java.time.LocalDateTime

data class UserScriptFeedback(
    val isCorrect: Boolean,
    val accuracy: Double,
    val fluency: Double,
    val feedback: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
) {
}