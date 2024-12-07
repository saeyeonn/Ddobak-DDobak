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
import org.springframework.web.bind.annotation.RestController
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

    fun getScript() {}

    fun getAnalysis() {}

    fun getFeedback() {}

    fun addWrongScript() {}

    fun deleteWrongScript() {}

    fun addDifficultScript() {}

    fun deleteDifficultScript() {}

    fun addVocabularies() {}
}