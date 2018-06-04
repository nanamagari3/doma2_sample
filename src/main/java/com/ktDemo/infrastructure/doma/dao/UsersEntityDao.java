package com.ktDemo.infrastructure.doma.dao;

import com.ktDemo.infrastructure.doma.entity.UsersEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;


/**
 */
@ConfigAutowireable
@Dao
public interface UsersEntityDao {

    /**
     * @param id
     * @return the UsersEntity entity
     */
    @Select
    UsersEntity selectById(Integer id);

    /**
     * @return the UsersEntity entity list
     */
    @Select
    List<UsersEntity> selectAll();

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(UsersEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(UsersEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(UsersEntity entity);
}