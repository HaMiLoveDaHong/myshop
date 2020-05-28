package com.hw.myshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hw.myshop.domain.po.UserRoleKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleKey> {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}