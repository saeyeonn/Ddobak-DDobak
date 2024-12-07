package org.itm.ddobak.user.review

data class VocabularyInfo(
    val id: Long,
    val word: String,
    val translation: String,
    val audioURL: String,
    val pronunciation: String,
    val scripts: List<String>,
    val translatedScripts: List<String>,
)
