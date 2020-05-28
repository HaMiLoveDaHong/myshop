package com.hw.myshop.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hw.myshop.domain.po.TaskFileinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskFileinfoMapper extends BaseMapper<TaskFileinfo> {
    int deleteByPrimaryKey(Long id);

    int insert(TaskFileinfo record);

    int insertSelective(TaskFileinfo record);

    TaskFileinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskFileinfo record);

    int updateByPrimaryKey(TaskFileinfo record);
}