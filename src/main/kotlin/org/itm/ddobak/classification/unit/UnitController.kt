package org.itm.ddobak.classification.unit

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/classification/units")
@Tag(name = "Unit Management", description = "Operations related to managing units" )
class UnitController() {
    @Operation(
        summary = "Get unit list",
        description = "Get a list of units with their respective script counts",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getUnitList(
        @RequestParam(value = "languageId", required = true) languageId: Long,
        @RequestParam(value = "categoryId", required = true) categoryId: Long,
    ): ResponseEntity<List<UnitInfo>> {
        val response = mutableListOf(
            UnitInfo(
                id = 3,
                number = 1,
                scriptCount = 10,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            UnitInfo(
                id = 6,
                number = 2,
                scriptCount = 10,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            UnitInfo(
                id = 10,
                number = 3,
                scriptCount = 3,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
        return ResponseEntity.ok(response)
    }

    @Operation(
        summary = "Create a new unit",
        description = "Create a new unit with the given name",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping
    fun createUnit(
        @RequestParam(value = "languageId", required = true) languageId: Long,
        @RequestParam(value = "categoryId", required = true) categoryId: Long,
        ): ResponseEntity<UnitInfo> {
        return ResponseEntity.ok(
            UnitInfo(
                id = 15,
                number = 4,
                scriptCount = 0,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
    }


    @Operation(
        summary = "Delete a unit",
        description = "Delete the unit with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @DeleteMapping("/{unitId}")
    fun deleteUnit(@PathVariable unitId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}