package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example11 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
                ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        //Lucy
        System.out.println("Person name from Spring Context is: "
                + person.getName());
        System.out.println("Vehicle name from Spring Context is: "
                + vehicle.getName());

        person.setName("PHUOCNT");
        System.out.println("Vehicle that Person own is: "
                + person.getVehicle());

        //Lucy
        Person person2 = context.getBean(Person.class);
        System.out.println("Person2 name from Spring Context is: "
                + person2.getName());

        //PHUOCNT
        System.out.println("Person name from Spring Context is: "
                + person.getName());
    }
}
