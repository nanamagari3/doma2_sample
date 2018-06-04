package com.ktDemo.infrastructure.doma.dao;

import com.ktDemo.infrastructure.doma.entity.UsersEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;


/**
 * Users Dao
 * (自動生成)
 */
@ConfigAutowireable
@Dao
public interface UsersEntityDao {

    /**
     * IDで検索
     * @param id
     * @return the UsersEntity entity
     */
    @Select
    UsersEntity selectById(Integer id);

    /**
     * 全レコード取得
     * @return the UsersEntity entity list
     */
    @Select
    List<UsersEntity> selectAll();

    /**
     * 追加
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(UsersEntity entity);

    /**
     * 更新
     * @param entity
     * @return affected rows
     */
    @Update
    int update(UsersEntity entity);

    /**
     * 削除
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(UsersEntity entity);
}