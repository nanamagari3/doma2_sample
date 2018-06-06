package com.ktDemo.application.request

/**
 * リクエストパラメータ(Insert/Update)
 */
data class SaveRequest(
        val id: Int,
        val firstName: String,
        val lastName: String? = null
)