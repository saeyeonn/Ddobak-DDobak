package org.itm.ddobak.admin.unit

import java.time.LocalDateTime

data class UnitInfo(
    val id: Long,
    val number: Long,
    val scriptCount : Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)