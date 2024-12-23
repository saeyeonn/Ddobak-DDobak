package org.itm.ddobak.admin.category

import java.time.LocalDateTime

data class CategoryInfo(
    val id: Long,
    val name: String,
    val scriptCount : Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)