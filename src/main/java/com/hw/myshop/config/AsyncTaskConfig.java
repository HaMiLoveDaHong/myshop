package com.hw.myshop.config;

/**
 * @author zhanghongwei
 * @since 2020/5/27
 */

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 * @author zhanghongwei
 * @since 2020/5/26
 */
@Component
public class AsyncTaskConfig {
    //接收核心线程数
    private int bookCorePoolSize = 10;
    //接收最大线程数
    private int bookMaxPoolSize =50;
    //接收队列容量
    private int bookQueueCapacity=100;
    //接收线程活跃时间（秒）
    private int bookKeepAliveSeconds=60000;

    /**
     * @return TaskExecutor taskExecutor接口
     * @since JDK 1.8
     */
    @Bean(name="threadPoolTask")
    public ThreadPoolTaskExecutor bookTaskExecutor() {
        //newFixedThreadPool
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(bookCorePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(bookMaxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(bookQueueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(bookKeepAliveSeconds);
        // 设置拒绝策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}

