package org.itm.ddobak.admin.error


import java.time.LocalDateTime
data class ErrorInfo(
    val id: Long,
    val message: String,
    val statusCode: Int,
    val priority: ErrorPriority,
    val status : ErrorStatus,
    val errorLocation: String,
    val userId: Long,
    val stackTrace: String,
    val timeStamp: LocalDateTime
    )
