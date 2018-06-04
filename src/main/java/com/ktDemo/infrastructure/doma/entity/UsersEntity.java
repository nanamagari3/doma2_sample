package com.ktDemo.infrastructure.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * Users Entity
 * (自動生成)
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "users")
public class UsersEntity {

    /**
     * id
     */
    @Id
    public Integer id;

    /** 性 */
    public String firstName;

    /** 名 */
    public String lastName;
}