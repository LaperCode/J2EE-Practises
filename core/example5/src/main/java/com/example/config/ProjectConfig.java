package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the configuration
class.
* */
@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {
    @Bean
    String getVehicleName() {
        return "Vehicle";
    }

    @Bean("name")
    String getName() {
        return "KIA Morning";
    }

    @Bean
    double getPrice1() {return 100.0;}

    @Bean (name="price")
    double getPrice2() {return 150.0;}

    @Bean(name="audiVehicle")
    //@Scope(scopeName = "prototpe")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    Vehicle vehicle1() {
        var veh = new Vehicle("Audi", 1000000);

        return veh;
    }

    @Bean(value="hondaVehicle")
    Vehicle vehicle2() {
        var veh = new Vehicle("Honda", 100000);
        return veh;
    }
}
