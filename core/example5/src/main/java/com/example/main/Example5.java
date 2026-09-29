package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


//        Vehicle vehicle = context.getBean(Vehicle.class);
//
//        System.out.println("Component Vehicle name from Spring Context is: "
//                + vehicle.getName() + " " +vehicle.getPrice() );
//        vehicle.printHello();


        Vehicle v = context.getBean("audiVehicle", Vehicle.class);
        Vehicle v2 = context.getBean("audiVehicle", Vehicle.class);

        v2.setName("audi new");
        System.out.println(v.getName());
        System.out.println(v==v2);
    }
}
