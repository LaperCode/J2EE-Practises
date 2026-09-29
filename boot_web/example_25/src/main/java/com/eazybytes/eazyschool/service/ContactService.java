package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.EazyschoolApplication;
import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service(value="contactService")
public class ContactService {

    public void listAllBeans() {
        String[] beanNames = EazyschoolApplication.applicationContext.getBeanDefinitionNames();
        // You can sort them for easier viewing
        java.util.Arrays.sort(beanNames);

        for (String beanName : beanNames) {
            System.out.println("Bean Name: " + beanName);
            // Optionally, you can also get the bean's class type
            // System.out.println("Bean Type: " + applicationContext.getBean(beanName).getClass().getName());
        }
    }
    private int counter = 0;

    public ContactService(){
        System.out.println("Contact Service Bean initialized");
    }

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());

        listAllBeans();
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
