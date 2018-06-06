package com.ktDemo.application.request

data class HelloRequest(
        val firstName: String,
        val lastName: String? = null
)