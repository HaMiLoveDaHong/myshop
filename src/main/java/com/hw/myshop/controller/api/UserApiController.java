package com.hw.myshop.controller.api;

import com.hw.myshop.domain.po.User;
import com.hw.myshop.service.user.UserService;
import com.hw.myshop.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghongwei
 * @since 2020/5/27
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    UserService userService;


    /**
     * 高并发处理数据，是否保持数据ACID
     * @return
     */
    @RequestMapping("highConcurrencyUpdate")
    public String highConcurrencyUpdate(){
        log.info("接口：/api/user/highConcurrencyUpdate");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                userService.highConcurrencyUpdate();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        return "成功";
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("findAll")
    public Map findAll(){
        List<User> users = userService.findAll();

        Map<String,List<User>> result = new HashMap();
        result.put("users", ObjectUtils.isEmpty(users)?new ArrayList():users);
        return result;
    }
}
