package com.daniyal.flashtalk.data.model

data class User(
    var id: String,
    var email: String,
    var password: String,
    var fullName: String,
    var image: String = "https://picsum.photos/200",
    var bio: String ,
    var phoneNumber: String,
    )
