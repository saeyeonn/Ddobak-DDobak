package org.itm.ddobak.user.statistics

data class UserStatisticsInfo(
    val progressRate: Double,
    val accuracyRate: Double,
    val fluencyRate: Double,
    val studiedScripts: Long,
    val studyHour: Long,
    val statPeriod: StatisticsPeriod,
    val graphInfoList: List<UserStatsGraphInfo>
)
