package com.ktDemo.domain.repository

import com.ktDemo.infrastructure.hibernate.entity.DetailsEntity
import com.ktDemo.infrastructure.hibernate.entity.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository
 */
interface UsersRepository : JpaRepository<UsersEntity, Long>

interface UsersDetailsRepository : JpaRepository<DetailsEntity, Long>
