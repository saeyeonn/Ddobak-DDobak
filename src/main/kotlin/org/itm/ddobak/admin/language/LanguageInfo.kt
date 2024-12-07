package org.itm.ddobak.admin.language

import java.time.LocalDateTime

data class LanguageInfo(
    val id: Long,
    val name: String,
    val scriptCount : Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)