package org.itm.ddobak.user.notification

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalTime

@RestController
@RequestMapping("/api/v1/user/{userId}/notifications")
@Tag(name = "Notification Settings", description = "Operations related to managing notification settings" )
internal
class NotificationController {
    @Operation(
        summary = "Current Notification Settings",
        description = "Get the current notification settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getNotificationSettings(@PathVariable userId: Long): ResponseEntity<NotificationSettings> {
        return ResponseEntity.ok(
            NotificationSettings(
                enabled = true,
                days = listOf(NotificationDays.MON, NotificationDays.WED),
                time = LocalTime.of(9, 0)
            )
        )
    }

    @Operation(
        summary = "Update Notification Settings",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PatchMapping
    fun updateNotificationSettings(
        @PathVariable userId: Long,
        @RequestBody notificationSettings: NotificationSettings
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}