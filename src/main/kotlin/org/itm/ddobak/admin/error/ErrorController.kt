package org.itm.ddobak.admin.error

import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.models.media.Schema
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/errors")
@Tag(name = "Error Management", description = "Operations related to managing errors"  )
class ErrorController {

    @Operation(
        summary = "Get error list",
        description = "Get a list of errors with their respective details",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getErrorList() : ResponseEntity<List<ErrorInfo>> {
        return ResponseEntity.ok(listOf(
            ErrorInfo(
                id = 1,
                message = "Description of Error 1",
                statusCode = 500,
                priority = ErrorPriority.P0,
                status = ErrorStatus.IN_PROGRESS,
                errorLocation = "Location of Error 1",
                stackTrace = "Stack trace of Error 1",
                userId = 1,
                timeStamp = LocalDateTime.now(),

            ),
            ErrorInfo(
                id = 2,
                message = "Description of Error 2",
                statusCode = 500,
                priority = ErrorPriority.P1,
                status = ErrorStatus.NEW,
                errorLocation = "Location of Error 2",
                stackTrace = "Stack trace of Error 2",
                userId = 4,
                timeStamp = LocalDateTime.now(),
                )
        ))
    }

    @Operation(
        summary = "Get error details",
        description = "Get the details of a specific error",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found")
        ]
    )
    @PatchMapping("/{errorId}/handle")
    fun startHandlingError(@PathVariable errorId: Long) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        summary = "Report error handling",
        description = "Report the handling of a specific error",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden")
        ]
    )
    @PostMapping("/{errorId}/report")
    fun reportErrorHandling(@PathVariable errorId: Long, @RequestParam request: ErrorHandleRequest) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}