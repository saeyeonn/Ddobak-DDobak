package org.itm.ddobak.user.statistics

import java.time.LocalDateTime

data class UserUnitStatisticsInfo(
    val accuracyRate: Double,
    val fluencyRate: Double,
    val studyHour: Long,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)
