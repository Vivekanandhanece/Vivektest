package com.example.demo;


import models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import repositories.UserRepository;

@ComponentScan(basePackages ={ "controller"})
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class RestApidDemoApplication {
	//@Autowired
	 //UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(RestApidDemoApplication.class, args);

			}





	}





