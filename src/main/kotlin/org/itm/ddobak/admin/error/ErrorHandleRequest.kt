package org.itm.ddobak.admin.error

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.context.annotation.Description

@Description("Request for handling an error")
data class ErrorHandleRequest(
    @Schema(description = "ID of the error to be handled")
    val errorId: Long,
    @Schema(description = "Comment explaining the handling of the error")
    val handlingComment: String,
    @Schema(description = "New code for the error")
    val revisedCode: String,
)
