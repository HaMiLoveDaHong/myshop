package com.hw.myshop.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hw.myshop.domain.po.TaskFileinfo;
import com.hw.myshop.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 条件更新
     * @param originName
     * @param newName
     */
    void updateNewNameByOriginName(@Param("originName") String originName, @Param("newName") String newName);

    List<User> findAll();

    /**
     * 根据记录更新
     * @param user
     * @return
     */
    int updateNameById(User user);
}