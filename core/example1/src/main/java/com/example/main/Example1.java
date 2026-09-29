package com.example.main;

import com.example.beans.BubbleSort;
import com.example.beans.QuickSort;
import com.example.beans.Sort;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {
        //No Spring
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());

        Sort sort1 = new QuickSort();
        int array1[] = {1, 3, 4, 5, 2};
        sort1.sort(array1);



        //Have Spring
        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        // Spring IoC Container
        var context = new AnnotationConfigApplicationContext
                (ProjectConfig.class);

        //Sort Implementation in .jar file


        // Application
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        /*
        We don’t need to do any explicit casting while fetching a bean from context.
        Spring is smart enough to look for a bean of the type you requested in its context.
        If such a bean doesn’t exist,Spring will throw an exception.
        * */
        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is: " + num);

        Sort sort = context.getBean(Sort.class);
        int array[] = {1, 3, 4, 5, 2};
        sort.sort(array);
    }
}
