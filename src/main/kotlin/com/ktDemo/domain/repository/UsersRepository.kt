package com.ktDemo.domain.repository

import com.ktDemo.domain.model.Users

/**
 * Repository
 */
interface UsersRepository {
    fun findAll(): List<Users>
    fun findById(id: Int): Users
    fun regist(users: Users): Int
    fun update(users: Users): Int
    fun delete(id: Int): Int
}
