package org.itm.ddobak.user.statistics

import jakarta.annotation.Nullable
import org.itm.ddobak.classification.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user/{userId}/statistics")
class UserStatisticsController {
    @GetMapping
    fun getStatistics(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long,
        @RequestParam(value = "languageId") @Nullable difficultyLevel: DifficultyLevel,
        @RequestParam @Nullable statPeriod: StatisticsPeriod
    ): ResponseEntity<UserStatisticsInfo> {
        return ResponseEntity.ok(
            UserStatisticsInfo(
                progressRate = 95.5,
                accuracyRate = 85.2,
                fluencyRate = 98.0,
                studiedScripts = 500,
                studyHour = 2400,
                statPeriod = statPeriod,
                graphInfoList = mutableListOf(
                    UserStatsGraphInfo(
                        period = 1,
                        accuracyRate = 30.3,
                    ),
                    UserStatsGraphInfo(
                        period = 2,
                        accuracyRate = 50.3,
                    ),
                    UserStatsGraphInfo(
                        period = 3,
                        accuracyRate = 70.3,
                    )
                )
            )
        )
    }
}