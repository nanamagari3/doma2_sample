package com.ktDemo.infrastructure.hibernate

import com.ktDemo.domain.model.Users
import com.ktDemo.domain.repository.UsersRepository
import com.ktDemo.domain.service.UsersService
import com.ktDemo.infrastructure.hibernate.entity.UsersEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

/**
 * Repository実装クラス
 * Dao(Java) - Repository(Kotlin)間のブリッジ
 */

@Repository
class UsersRepositoryDomaImpl(
        private val repo: UsersRepository
) : UsersService {

    override fun findAll(): List<Users> {
        return repo.findAll().map { _MapToModel(it) }
    }

    private fun _MapToModel(entity: UsersEntity): Users {
        return Users(
                id = entity.id.toInt(),
                firstName = entity.firstName,
                lastName = entity.lastName
        )
    }

    override fun findById(id: Int): Users {
        val entity = repo.findById(id.toLong()).orElse(null)

        return if (entity == null) {
            Users(id = null,
                    firstName = null,
                    lastName = null)
        } else {
            Users(
                    id = entity.id.toInt(),
                    firstName = entity.firstName,
                    lastName = entity.lastName
            )
        }
    }

    override fun regist(users: Users): Users {
        val result = repo.save(UsersEntity(id = users.id!!.toLong(), firstName = users.firstName!!, lastName = users.lastName))
        return Users(id = result.id.toInt(), firstName = result.firstName, lastName = result.lastName)
    }

    override fun update(users: Users): Int {

        return repo.findById(users.id!!.toLong()).map { ResponseEntity.ok().body(repo.save(it)) }.orElse(ResponseEntity.notFound().build()).statusCodeValue
    }

    override fun delete(id: Int): Int {
        return repo.findById(id.toLong()).map { ResponseEntity.ok().body(repo.delete(it)) }.orElse(ResponseEntity.notFound().build()).statusCodeValue
    }
}