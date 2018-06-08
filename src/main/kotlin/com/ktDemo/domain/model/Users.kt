package com.ktDemo.domain.model

import com.ktDemo.infrastructure.hibernate.entity.DetailsEntity

/**
 * Usersデータモデル
 */
data class Users(
        val id: Int? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val details: DetailsEntity? = null
)