package org.itm.ddobak.classification.unit

import java.time.LocalDateTime

data class UnitInfo(
    val id: Long,
    val number: Long,
    val scriptCount : Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)