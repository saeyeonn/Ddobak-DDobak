package org.itm.ddobak.user.settings

import org.itm.ddobak.classification.DifficultyLevel

data class StudySettings(
    val language: String,
    val category: String,
    val difficultyLevel: DifficultyLevel,
)
