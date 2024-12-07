package org.itm.ddobak.user.statistics

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.annotation.Nullable
import org.itm.ddobak.admin.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/user/{userId}/statistics")
class UserStatisticsController {
    @Operation(
        summary = "Get total statistics for a user",
        description = "Get the total statistics for a user based on the provided filter criteria",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getTotalStatistics(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam(value = "languageId") @Nullable difficultyLevel: DifficultyLevel?,
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

    @Operation(
        summary = "Get unit statistics for a user",
        description = "Get the unit statistics for a user based on the provided unit ID",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/unit/{unitId}")
    fun getUnitStatistics(
        @PathVariable userId: Long,
        @PathVariable unitId: Long,
    ) : ResponseEntity<UserUnitStatisticsInfo> {
        return ResponseEntity.ok(
            UserUnitStatisticsInfo(
                accuracyRate = 95.5,
                fluencyRate = 98.0,
                studyHour = 2400,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }
}