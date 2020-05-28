package com.hw.myshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hw.myshop.domain.po.PermissionRoleKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionRoleMapper extends BaseMapper<PermissionRoleKey> {
    int deleteByPrimaryKey(PermissionRoleKey key);

    int insert(PermissionRoleKey record);

    int insertSelective(PermissionRoleKey record);
}