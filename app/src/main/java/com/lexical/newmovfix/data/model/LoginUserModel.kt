package com.lexical.newmovfix.data.model

data class LoginUserModel(
    val userId: Int,
    val userName: String,
    val userEmail: String,
    val userAddress: String,
    val userDob: String
)