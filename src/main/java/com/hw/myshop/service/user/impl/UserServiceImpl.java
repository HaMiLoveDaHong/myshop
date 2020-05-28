package com.hw.myshop.service.user.impl;


import com.hw.myshop.dao.UserMapper;
import com.hw.myshop.domain.po.User;
import com.hw.myshop.service.user.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Slf4j
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Qualifier("threadPoolTask")
    @Autowired
    ThreadPoolTaskExecutor threadPoolTask;

    @Override
    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int updateNameById(User user) {
        return userMapper.updateNameById(user);
    }

    @Override
    public void highConcurrencyUpdate() {
        try {
            List<Integer> integers = new ArrayList();
            for (int i=1;i<=500;i++){
                integers.add(i);
            }

            //分割
            int listStart,listEnd;
            int groupSize = 5;
            int groupNum;
            if (integers.size() < groupSize){
                groupNum = 1;
            }else if (integers.size()%groupSize ==0){
                groupNum = integers.size()/groupSize;
            }else {
                groupNum = (integers.size()/groupSize)+1;
            }
            HighConcurrencyUpdateThread updateThread =null;
            for (int i=0;i<groupNum;i++){

                listStart = i*groupSize;
                listEnd = (i+1)*groupSize;
                if (integers.size() < listEnd){
                    listEnd = integers.size();
                }
                List<Integer> list = integers.subList(listStart,listEnd);
                updateThread = new HighConcurrencyUpdateThread(list);
                threadPoolTask.submit(updateThread);
            }

        }catch (Exception e){
            log.error("异常:{}",e);
        }
        log.info("执行完成");
    }

    @Data
    public class HighConcurrencyUpdateThread implements Callable<String> {

        private List<Integer> integers;

        public HighConcurrencyUpdateThread() {
        }

        public HighConcurrencyUpdateThread(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        public String call() throws Exception {
            for (Integer integer:integers){
                while (true){
                    try {
                        User user = userMapper.selectByPrimaryKey(1);
                        String originName = user.getName();
                        String newName = String.valueOf(Integer.valueOf(originName) + 1);
                        user.setName(newName);
                        user.setOldName(originName);
//                        updateNameById(user);
                        userMapper.updateNameById(user);
                        break;
                    }catch (Exception e){
                        log.error("异常：{}",e);
                        Thread.sleep(50);
                    }
                }
            }

            log.info("线程名称：",Thread.currentThread().getName());
            return "成功";
        }
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
