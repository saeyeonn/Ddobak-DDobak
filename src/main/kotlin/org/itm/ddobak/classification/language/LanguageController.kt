package org.itm.ddobak.classification.language

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/classification/languages")
@Tag(name = "Language Management", description = "Operations related to managing languages"  )
class LanguageController() {
    @Operation(
        summary = "Get language list",
        description = "Get a list of languages with their respective script counts",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getLanguageList(): ResponseEntity<List<LanguageInfo>> {
        val response = mutableListOf(
            LanguageInfo(
                id = 1,
                name = "English",
                scriptCount = 160,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            LanguageInfo(
                id = 2,
                name = "Chinese(Mandarin)",
                scriptCount = 100,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
        return ResponseEntity.ok(response)
    }

    @Operation(
        summary = "Create a new language",
        description = "Create a new language with the given name",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping
    fun createLanguage(@RequestParam name: String): ResponseEntity<LanguageInfo> {
        return ResponseEntity.ok(
            LanguageInfo(
                id = 3,
                name = name,
                scriptCount = 0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }

    @Operation(
        summary = "Update a language",
        description = "Update the name of the language with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PatchMapping
    fun modifyLanguage(@RequestParam name: String): ResponseEntity<LanguageInfo> {
        return ResponseEntity.ok(
            LanguageInfo(
                id = 2,
                name = name,
                scriptCount = 0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }

    @Operation(
        summary = "Delete a language",
        description = "Delete the language with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @DeleteMapping("/{languageId}")
    fun deleteLanguage(@PathVariable languageId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}