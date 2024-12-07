package org.itm.ddobak.user

import org.itm.ddobak.classification.DifficultyLevel

data class RecentProgress(
    val category : String,
    val difficultyLevel : DifficultyLevel,
    val unit : Int,
)
