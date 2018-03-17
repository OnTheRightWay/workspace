package com.lanou.demo5_多线程;

import com.lanou.demo5_多线程.config.TaskExecutorConfig;
import com.lanou.demo5_多线程.service.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(TaskExecutorConfig.class);
        context.refresh();
        AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            taskService.execureAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
