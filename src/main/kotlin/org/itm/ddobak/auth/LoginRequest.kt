package org.itm.ddobak.auth

data class LoginRequest(
    val email: String,
    val password: String,
)
