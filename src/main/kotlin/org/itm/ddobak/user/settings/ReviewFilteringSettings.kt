package org.itm.ddobak.user.settings

import jakarta.annotation.Nullable
import org.itm.ddobak.admin.DifficultyLevel

data class ReviewFilteringSettings(
    @Nullable
    val languageId: Long?,
    @Nullable
    val categoryId: Long?,
    @Nullable
    val difficultyLevel: DifficultyLevel?
) {
}