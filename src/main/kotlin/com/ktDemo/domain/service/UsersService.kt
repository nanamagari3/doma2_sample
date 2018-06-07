package com.ktDemo.domain.service

import com.ktDemo.domain.model.Users

/**
 * Repository
 */
interface UsersService {
    fun findAll(): List<Users>
    fun findById(id: Int): Users
    fun regist(users: Users): Users
    fun update(users: Users): Int
    fun delete(id: Int): Int
}
