package com.hw.myshop.service.user;


import com.hw.myshop.domain.po.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(int id);

    /**
     * 更新
     * @param user
     * @return
     */
    int updateNameById(User user);

    /**
     * 高并发处理数据，是否保持数据ACID
     */
    void highConcurrencyUpdate();

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
