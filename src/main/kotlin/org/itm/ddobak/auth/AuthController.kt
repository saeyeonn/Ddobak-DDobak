package org.itm.ddobak.auth

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.itm.ddobak.admin.DifficultyLevel
import org.itm.ddobak.user.RecentProgress
import org.itm.ddobak.user.settings.StudySettings
import org.itm.ontime.dobak.auth.SignUpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
) {
    @Operation(
        summary = "Sign up a new user",
        description = "Create a new user account",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "409", description = "Email already exists"),
            ApiResponse(responseCode = "500", description = "Internal server error"),
        ]
    )
    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        summary = "Login a user",
        description = "Authenticate and authorize a user",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
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

    @Operation(
        summary = "Logout a user",
        description = "Invalidate a user's session",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
        ]
    )
    @PostMapping("/logout")
    fun logout(@RequestParam userId: Long){
    }
}