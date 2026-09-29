package org.example;

import org.example.demo_du_an_1_3.AppConfig;
import org.example.demo_du_an_1_3.MessageService;
import org.example.demo_du_an_1_3.SingletonMessageService;
import org.example.demo_du_an_1_3.TwitterMessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== SINGLETON SCOPE ===");
        MessageService singleton1 = context.getBean(SingletonMessageService.class);
        singleton1.setMessage("Message for Singleton Scope");
        MessageService singleton2 = context.getBean(SingletonMessageService.class);

        System.out.println("Nội dung bean 1: " + singleton1.getMessage());
        System.out.println("Nội dung bean 2: " + singleton2.getMessage());
        System.out.println("Cùng đối tượng? " + (singleton1 == singleton2));
        System.out.println("ID bean 1: " + System.identityHashCode(singleton1));
        System.out.println("ID bean 2: " + System.identityHashCode(singleton2));

        System.out.println("\n=== PROTOTYPE SCOPE ===");
        MessageService prototype1 = context.getBean(TwitterMessageService.class);
        prototype1.setMessage("Message for Prototype Scope");
        MessageService prototype2 = context.getBean(TwitterMessageService.class);

        System.out.println("Nội dung bean 1: " + prototype1.getMessage());
        System.out.println("Nội dung bean 2: " + prototype2.getMessage());
        System.out.println("Cùng đối tượng? " + (prototype1 == prototype2));
        System.out.println("ID bean 1: " + System.identityHashCode(prototype1));
        System.out.println("ID bean 2: " + System.identityHashCode(prototype2));

        context.close();
    }
}
