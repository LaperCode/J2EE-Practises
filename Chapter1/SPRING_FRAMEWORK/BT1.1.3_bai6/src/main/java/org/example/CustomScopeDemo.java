package org.example;

import org.example.config.AppConfig;
import org.example.service.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScopeDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Runnable task = () -> {

            MyBean bean1 = context.getBean(MyBean.class);
            MyBean bean2 = context.getBean(MyBean.class);

            System.out.println(Thread.currentThread().getName()
                    + " : " + (bean1 == bean2));
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}