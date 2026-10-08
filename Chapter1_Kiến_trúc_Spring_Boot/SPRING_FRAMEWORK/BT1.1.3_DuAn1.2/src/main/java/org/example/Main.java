package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. Lấy đối tượng lần 1 (Gọi là A)
        MessageService serviceA = context.getBean(MessageService.class);
        serviceA.setMessage("Đây là dữ liệu của thằng A");
        System.out.println("Message của A: " + serviceA.getMessage());
        System.out.println("Mã ID bộ nhớ của A: " + serviceA.hashCode());

        System.out.println("-------------------------");

        // 2. Lấy đối tượng lần 2 (Gọi là B)
        MessageService serviceB = context.getBean(MessageService.class);
        System.out.println("Message của B (chưa được set): " + serviceB.getMessage());
        System.out.println("Mã ID bộ nhớ của B: " + serviceB.hashCode());

        context.close();
    }
}