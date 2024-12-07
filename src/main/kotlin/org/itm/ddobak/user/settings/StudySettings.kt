package org.itm.ddobak.user.settings

import org.itm.ddobak.admin.DifficultyLevel

data class StudySettings(
    val language: String,
    val category: String,
    val difficultyLevel: DifficultyLevel,
)
