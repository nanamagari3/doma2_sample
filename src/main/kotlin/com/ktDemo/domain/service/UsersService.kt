package com.ktDemo.domain.service

import com.ktDemo.domain.model.Users

/**
 * Repository
 */
interface UsersService {
    fun findAll(): List<Users>
    fun findById(id: Int): Users
    fun regist(users: Users): Int
    fun update(users: Users): Users
    fun delete(id: Int): Int
}
