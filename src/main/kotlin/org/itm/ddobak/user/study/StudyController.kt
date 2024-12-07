package org.itm.ddobak.user.study

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.itm.ddobak.admin.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/user/{userId}/study")
class StudyController {
    @Operation(
        summary = "Save current progress",
        description = "Save the current progress of the user in the study",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @PostMapping("/progress")
    fun saveCurrentProgress(@PathVariable userId: Long, @RequestBody progress: UserProgress) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        summary = "Get current progress",
        description = "Get the current progress of the user in the study",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @GetMapping("/progress")
    fun getCurrentProgress(@PathVariable userId: Long) : ResponseEntity<UserProgress> {
        return ResponseEntity.ok(UserProgress(
            languageId = 1,
            categoryId = 1,
            difficultyLevel = DifficultyLevel.INTERMEDIATE,
            unitId = 5,
            scriptId = 9,
            createdDate = LocalDateTime.now(),
            modifiedDate = LocalDateTime.now()
        ))
    }

    @Operation(
        summary = "Get script content",
        description = "Get the script content for the given language, category, unit, and script",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @GetMapping("/{languageId}/{categoryId}/{unitId}/{scriptId}")
    fun getScript(
        @PathVariable userId: Long,
        @PathVariable languageId: Long,
        @PathVariable categoryId: Long,
        @PathVariable unitId: Long,
        @PathVariable scriptId: Long
    ) : ResponseEntity<ScriptContent>{
        return ResponseEntity.ok(
            ScriptContent(
                id = scriptId,
                title = "Order in a restaurant",
                script = "May I help you to order",
                translatedScript = "주문 도와드릴까요?",
                userAverageAccuracy = 85.5,
                userAverageFluency = 98.0,
                isLast = false
            )
        )
    }

    @Operation(
        summary = "Get script feedback",
        description = "Get the script feedback for the given script",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @PostMapping("/{scriptId}/feedback")
    fun createFeedback(
        @PathVariable userId: Long,
        @PathVariable scriptId: Long,
        @RequestBody audio: MultipartFile
    ) : ResponseEntity<UserScriptFeedback> {
        return ResponseEntity.ok(
            UserScriptFeedback(
                isCorrect = true,
                accuracy = 90.3,
                fluency = 80.3,
                feedback = "Good job! You have answered correctly.",
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
        ))
    }

    @Operation(
        summary = "Classify difficult script",
        description = "Classify the given script as difficult or not",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @PostMapping("/difficult-script/{scriptId}/")
    fun classifyDifficultScript(
        @PathVariable userId: Long,
        @PathVariable scriptId: Long,
        @RequestParam isDifficult: Boolean
    ) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}