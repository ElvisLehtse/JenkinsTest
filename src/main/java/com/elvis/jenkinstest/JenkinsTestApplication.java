package com.elvis.jenkinstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsTestApplication implements CommandLineRunner {

    @Autowired
    HelloWorldClass helloWorldClass;

    public static void main(String[] args) {
        SpringApplication.run(JenkinsTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        helloWorldClass.printHelloWorld();
    }
}
