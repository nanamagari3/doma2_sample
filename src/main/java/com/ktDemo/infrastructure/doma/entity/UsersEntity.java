package com.ktDemo.infrastructure.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 *
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "users")
public class UsersEntity {

    /**  */
    @Id
    public Integer id;

    /**  */
    public String firstName;

    /**  */
    public String lastName;
}