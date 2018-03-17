package com.lanou.demo5_多线程.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    /**
     * 通过@Async注解，表示该方法时一个异步方法
     * 如果将@Async注解表示在类的声明上，则表示这和类中所有的方法都是异步的
     * 异步方法，会被自动注入在TaskExecutorConfig类中反回的
     * 那个ThreadPoolTaskExecutor作为TaskExecutor
     * @param n
     */
    @Async
    public void execureAsyncTask(Integer n){
        System.out.println("异步任务执行："+n);
    }

    @Async
    public void executeAsyncTaskPlus(Integer n){
        System.out.println("异步任务执行+1："+(n+1));
    }
}
