package com.ktDemo.application.request

data class requestForm(
        val id: Int,
        val firstName: String,
        val lastName: String? = null
)