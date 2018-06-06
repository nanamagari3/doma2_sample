package com.ktDemo.infrastructure.doma

import com.ktDemo.domain.model.Users
import com.ktDemo.domain.repository.UsersRepository
import com.ktDemo.infrastructure.doma.dao.UsersEntityDao
import com.ktDemo.infrastructure.doma.entity.UsersEntity
import org.springframework.stereotype.Repository

/**
 * Repository実装クラス
 * Dao(Java) - Repository(Kotlin)間のブリッジ
 */
@Repository
class UsersRepositoryDomaImpl(
        private val usersEntityDao: UsersEntityDao
) : UsersRepository {
    override fun findAll(): List<Users> {
        return usersEntityDao.selectAll().map { _MapToModel(it) }
    }

    private fun _MapToModel(entity: UsersEntity): Users {
        return Users(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName
        )
    }

    override fun findById(id: Int): Users {
        val entity = usersEntityDao.selectById(id)

        return if (entity == null) {
            Users(id = null,
                    firstName = null,
                    lastName = null)
        } else {
            Users(
                    id = entity.id,
                    firstName = entity.firstName,
                    lastName = entity.lastName
            )
        }
    }

    override fun regist(users: Users): Int {
        val insertEntity = UsersEntity()
        insertEntity.id = users.id
        insertEntity.firstName = users.firstName
        insertEntity.lastName = users.lastName

        return usersEntityDao.insert(insertEntity)
    }

    override fun update(users: Users): Int {
        val insertEntity = UsersEntity()
        insertEntity.id = users.id
        insertEntity.firstName = users.firstName
        insertEntity.lastName = users.lastName

        return usersEntityDao.update(insertEntity)
    }

    override fun delete(id: Int): Int {
        val entity = usersEntityDao.selectById(id)

        return if (entity == null) {
            -1
        } else {
            usersEntityDao.delete(entity)
        }
    }
}