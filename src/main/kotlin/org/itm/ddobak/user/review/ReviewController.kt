package org.itm.ddobak.user.review

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.itm.ddobak.admin.DifficultyLevel
import org.itm.ddobak.user.settings.ReviewFilteringSettings
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/user/{userId}/review")
class ReviewController {

    @Operation(
        summary = "Get a wrong script list of a user for review",
        description = "Get a list of scripts for review based on the provided filter criteria",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/wrong-scripts")
    fun getWrongScriptList(
        @PathVariable userId: Long,
        @RequestBody wrongScriptFilter: ReviewFilteringSettings
    ) : ResponseEntity<List<ReviewScriptInfo>> {
        return ResponseEntity.ok(listOf(
            ReviewScriptInfo(
                id = 1,
                languageId = 1,
                categoryId = 1,
                difficultyLevel = DifficultyLevel.BEGINNER,
                title = "Order in Restaurant",
                userTrial = 2,
                userAverageAccuracy = 90.0,
                userAverageFluency = 95.0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            ReviewScriptInfo(
                id = 2,
                languageId = 1,
                categoryId = 2,
                difficultyLevel = DifficultyLevel.BEGINNER,
                title = "Ask for recommendations",
                userTrial = 3,
                userAverageAccuracy = 90.0,
                userAverageFluency = 95.0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        ))
    }

    @Operation(
        summary = "Get a wrong script list of a user for review",
        description = "Get a list of scripts for review based on the provided filter criteria",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/difficult-scripts")
    fun getDifficultScriptList(
        @PathVariable userId: Long,
        @RequestBody difficultScriptFilter: ReviewFilteringSettings
    ): ResponseEntity<List<ReviewScriptInfo>> {
        return ResponseEntity.ok(listOf(
            ReviewScriptInfo(
                id = 1,
                languageId = 1,
                categoryId = 1,
                difficultyLevel = DifficultyLevel.BEGINNER,
                title = "Order in Restaurant",
                userTrial = 2,
                userAverageAccuracy = 90.0,
                userAverageFluency = 95.0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            ReviewScriptInfo(
                id = 2,
                languageId = 1,
                categoryId = 2,
                difficultyLevel = DifficultyLevel.BEGINNER,
                title = "Ask for recommendations",
                userTrial = 3,
                userAverageAccuracy = 90.0,
                userAverageFluency = 95.0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        ))
    }

    @Operation(
        summary = "Get a wrong script list of a user for review",
        description = "Get a list of scripts for review based on the provided filter criteria",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping("/vocabulary")
    fun getVocabularyList(
        @PathVariable userId: Long,
        @RequestParam(value = "languageId") languageId: Long?
    ) : ResponseEntity<List<VocabularyInfo>> {
        return ResponseEntity.ok(listOf(
            VocabularyInfo(
                id = 1,
                word = "hello",
                translation = "안녕하세요",
                audioURL = "http://url.script.audio",
                pronunciation = "heh·low",
                scripts = listOf(
                    "Hello.", "Hello, my name is cherry."
                ),
                translatedScripts = listOf(
                    "안녕하세요", "안녕하세요, 제 이름은 체리입니다."
                ),
            ),
            VocabularyInfo(
                id = 2,
                word = "cook",
                translation = "요리",
                audioURL = "http://url.script.audio",
                pronunciation = "kʊk",
                scripts = listOf(
                    "I like to cook.", "Let's cook together."
                ),
                translatedScripts = listOf(
                    "저는 요리하는 것을 좋아해요.", "우리 함께 요리하자."
                ),
            )
        ))
    }
}