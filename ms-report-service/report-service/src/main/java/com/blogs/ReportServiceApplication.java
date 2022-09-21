package com.blogs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogs.bao.SubscriptedBAO;

@SpringBootApplication
public class ReportServiceApplication {

   // @Autowired
   // private ReportBAO bao;
    
    @Autowired
    private SubscriptedBAO subscriptedBAO;
    
    public static void main(String[] args) {
	SpringApplication.run(ReportServiceApplication.class, args);
    }

    @PostConstruct
    public void initMethod() {
	subscriptedBAO.checkingDataCustomerSubscripted();
    }
}
