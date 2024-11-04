package com.daniyal.flashtalk.data.model

data class User(
    var id: Int,
    var email: String,
    var password: String,
    var fullName: String,
    var image: Int?
)
