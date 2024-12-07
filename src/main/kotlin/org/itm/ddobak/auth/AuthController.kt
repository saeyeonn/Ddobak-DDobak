package org.itm.ddobak.auth

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.itm.ddobak.classification.DifficultyLevel
import org.itm.ddobak.user.RecentProgress
import org.itm.ddobak.user.settings.StudySettings
import org.itm.ontime.dobak.auth.SignUpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
) {
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Success"
        ),
        ApiResponse(
            responseCode = "400",
            description = "Request parameter error"
        ),
        ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
        ),
        ApiResponse(
            responseCode = "403",
            description = "Forbidden"
        ),
    )
    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Success"
        ),
        ApiResponse(
            responseCode = "400",
            description = "Request parameter error"
        ),
        ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
        ),
        ApiResponse(
            responseCode = "403",
            description = "Forbidden"
        ),
    )
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(
            UserResponse(
                id = 1,
                email = "ddobak@example.com",
                name = "test",
                studySettings = StudySettings(
                    language = "English",
                    category = "Travel",
                    difficultyLevel = DifficultyLevel.INTERMEDIATE
                ),
                recentProgress = RecentProgress(
                    category = "Travel",
                    difficultyLevel = DifficultyLevel.INTERMEDIATE,
                    unit = 5
                )
            )
        )
    }

    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            description = "Success"
        ),
        ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
        ),
        ApiResponse(
            responseCode = "403",
            description = "Forbidden"
        )
    )
    @PostMapping("/logout")
    fun logout(@RequestParam userId: Long){
    }
}