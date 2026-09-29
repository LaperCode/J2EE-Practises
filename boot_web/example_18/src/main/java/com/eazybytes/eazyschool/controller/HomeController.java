package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.beans.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    //@Qualifier(value = "audiVehicle")
    private Vehicle vehicle;

    @RequestMapping("/home1")
    public String displayHomePage() {
        //...
        System.out.println("VEHICLE" + vehicle.getName());

        //...
        return "home.html";
    }

}
