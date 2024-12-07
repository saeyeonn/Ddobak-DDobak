package org.itm.ddobak.user.study

import org.itm.ddobak.admin.DifficultyLevel
import java.time.LocalDateTime
import java.util.stream.LongStream.LongMapMultiConsumer

data class UserProgress(
    val languageId: Long,
    val categoryId: Long,
    val difficultyLevel: DifficultyLevel,
    val unitId: Long,
    val scriptId: Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)
