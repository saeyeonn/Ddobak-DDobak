package org.itm.ddobak.user

import org.itm.ddobak.admin.DifficultyLevel

data class RecentProgress(
    val category : String,
    val difficultyLevel : DifficultyLevel,
    val unit : Int,
)
