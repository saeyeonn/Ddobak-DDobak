package org.itm.ddobak.classification.category

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/classification/categories")
@Tag(name = "Category Management", description = "Operations related to managing categories"  )
class CategoryController() {
    @Operation(
        summary = "Get category list",
        description = "Get a list of categories with their respective script counts",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getCategoryList(): ResponseEntity<List<CategoryInfo>> {
        val response = mutableListOf(
            CategoryInfo(
                id = 1,
                name = "Travel",
                scriptCount = 250,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            CategoryInfo(
                id = 2,
                name = "Business",
                scriptCount = 110,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
        return ResponseEntity.ok(response)
    }

    @Operation(
        summary = "Create a new category",
        description = "Create a new category with the given name",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping
    fun createCategory(@RequestParam name: String): ResponseEntity<CategoryInfo> {
        return ResponseEntity.ok(
            CategoryInfo(
                id = 3,
                name = name,
                scriptCount = 0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }

    @Operation(
        summary = "Update a category",
        description = "Update the name of the category with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PatchMapping("/{categoryId}")
    fun modifyCategory(@PathVariable categoryId: Long): ResponseEntity<CategoryInfo> {
        return ResponseEntity.ok(
            CategoryInfo(
                id = categoryId,
                name = "Travel",
                scriptCount = 0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }

    @Operation(
        summary = "Delete a category",
        description = "Delete the category with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @DeleteMapping("/{categoryId}")
    fun deleteCategory(@PathVariable categoryId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}