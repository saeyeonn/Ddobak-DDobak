package org.itm.ontime.dobak.auth

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
)
