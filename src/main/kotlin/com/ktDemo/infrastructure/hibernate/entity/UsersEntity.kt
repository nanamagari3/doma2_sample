package com.ktDemo.infrastructure.hibernate.entity

import java.io.Serializable
import javax.persistence.*


/**
 * Users Entity
 */
@Entity
@Table(name = "users")
data class UsersEntity(

        /** ID */
        @Id
        @Column(name = "id", nullable = false)
        var id: Long = -1,

        /** 性  */
        @Column(name = "first_name", nullable = false)
        var firstName: String = "",

        /** 名  */
        @Column(name = "last_name", nullable = true)
        var lastName: String? = null,

        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        val detail: DetailsEntity? = null

) : Serializable