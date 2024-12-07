package org.itm.ddobak.admin.script

import org.itm.ddobak.admin.DifficultyLevel

data class CollectScriptRequest(
    val languageId: Long,
    val categoryId: Long,
    val difficultyLevel: DifficultyLevel,
) {
}