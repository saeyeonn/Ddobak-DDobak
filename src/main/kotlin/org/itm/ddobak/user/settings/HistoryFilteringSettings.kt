package org.itm.ddobak.user.settings

import jakarta.annotation.Nullable
import jakarta.persistence.criteria.Order
import org.itm.ddobak.admin.DifficultyLevel

data class HistoryFilteringSettings(
    @Nullable
    val languageId: Long?,
    @Nullable
    val categoryId: Long?,
    @Nullable
    val difficultyLevel: DifficultyLevel?,
    @Nullable
    val unitId: Long?,
    @Nullable
    val descent: Boolean?,
) {
}