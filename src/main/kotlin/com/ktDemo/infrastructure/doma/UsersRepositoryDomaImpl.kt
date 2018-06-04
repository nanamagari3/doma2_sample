package com.ktDemo.infrastructure.doma

import com.ktDemo.domain.model.Users
import com.ktDemo.domain.repository.UsersRepository
import com.ktDemo.infrastructure.doma.dao.UsersEntityDao
import com.ktDemo.infrastructure.doma.entity.UsersEntity
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryDomaImpl(
        private val usersDomaDao: UsersEntityDao
) : UsersRepository {
    override fun findAll(): List<Users> {
        return usersDomaDao.selectAll().map { _MapToModel(it) }
    }

    private fun _MapToModel(entity: UsersEntity): Users {
        return Users(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName
        )
    }

    override fun findById(id: Int): Users {
        val entity = usersDomaDao.selectById(id)

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

        return usersDomaDao.insert(insertEntity)
    }

    override fun update(users: Users): Int {
        val insertEntity = UsersEntity()
        insertEntity.id = users.id
        insertEntity.firstName = users.firstName
        insertEntity.lastName = users.lastName

        return usersDomaDao.update(insertEntity)
    }

    override fun delete(id: Int): Int {
        val entity = usersDomaDao.selectById(id)

        return if (entity == null) {
            -1
        } else {
            usersDomaDao.delete(entity)
        }
    }
}