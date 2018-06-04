package com.ktDemo.application.request

/**
 * リクエストパラメータ データモデル
 */
data class requestForm(
        val id: Int,
        val firstName: String,
        val lastName: String? = null
)