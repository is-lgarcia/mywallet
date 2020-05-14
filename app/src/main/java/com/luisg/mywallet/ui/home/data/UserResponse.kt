package com.luisg.mywallet.ui.home.data

data class UserResponse(
    val id: String,
    val token: String,
    val userName: String,
    val userPhotoURL: String,
    val tokenTransfer: String
)