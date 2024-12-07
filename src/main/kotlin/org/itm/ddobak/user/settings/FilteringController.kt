package org.itm.ddobak.user.settings

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.annotation.Nullable
import org.itm.ddobak.admin.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user/{userId}/settings/filtering")
@Tag(name = "Review Filtering Settings", description = "Operations related to managing review filtering settings" )
class FilteringController {

    @Operation(
        description = "Get the current review filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/wrong-scripts")
    fun getWrongScriptSettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?
    ) : ResponseEntity<ReviewFilteringSettings> {
        return ResponseEntity.ok(
            ReviewFilteringSettings(
                languageId = 1,
                categoryId = 2,
                difficultyLevel = null
            )
        )
    }

    @Operation(
        description = "Save the review filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping("/wrong-scripts")
    fun saveWrongScriptSettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?
    ) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        description = "Get the current history filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/difficult-scripts")
    fun getDifficultScriptSettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?
    ) : ResponseEntity<ReviewFilteringSettings> {
        return ResponseEntity.ok(
            ReviewFilteringSettings(
                languageId = 1,
                categoryId = null,
                difficultyLevel = null
            )
        )
    }

    @Operation(
        description = "Save the history filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping("/difficult-scripts")
    fun saveDifficultScriptSettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?
    ) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        description = "Get the current history filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/history")
    fun getHistorySettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?,
        @RequestParam @Nullable unitId: Long?,
        @RequestParam @Nullable descent: Boolean?
    ) : ResponseEntity<HistoryFilteringSettings> {
        return ResponseEntity.ok(
            HistoryFilteringSettings(
                languageId = 1,
                categoryId = null,
                difficultyLevel = null,
                unitId = null,
                descent = false
            )
        )
    }

    @Operation(
        description = "Save the history filtering settings for the specified user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping("/history")
    fun saveHistorySettings(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") @Nullable languageId: Long?,
        @RequestParam(value = "categoryId") @Nullable categoryId: Long?,
        @RequestParam @Nullable difficultyLevel: DifficultyLevel?,
        @RequestParam @Nullable unitId: Long?,
        @RequestParam @Nullable descent: Boolean?
    ) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}

