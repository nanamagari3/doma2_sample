package com.ktDemo.infrastructure.hibernate.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


/**
 * UsersDetails Entity
 */
@Entity
@Table(name = "users_details")
data class DetailsEntity(

        /** ID */
        @Id
        @Column(name = "id", nullable = false)
        var id: Long = -1,

        /** 住所  */
        @Column(name = "address", nullable = true)
        var address: String? = "",

        /** 電話番号  */
        @Column(name = "tel", nullable = true)
        var tel: String? = null

) : Serializable