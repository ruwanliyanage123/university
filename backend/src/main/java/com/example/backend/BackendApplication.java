package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}


    class Company{
        private int companyId;
        private String companyName;
        private String address;

        //getters and setters
    }

    class Employee{
        private int id;
        private String name;
        private int companyId;//this field use to refer the company table

        //getters and setters
    }