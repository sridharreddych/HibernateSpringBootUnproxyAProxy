package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
   
    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
        
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {            
            bookstoreService.authorNotEqualsProxy();
            System.out.println("------------------------------------------------------");
            bookstoreService.authorEqualsUnproxy();
        };
    }
}

/*
 * 
 * 
 * 
 * 
 * 
 * How To Unproxy A Proxy

Description: A Hibernate proxy can be useful when a child entity can be persisted with a reference to its parent (@ManyToOne or @OneToOne association). In such cases, fetching the parent entity from the database (execute the SELECT statement) is a performance penalty and a pointless action. Hibernate can set the underlying foreign key value for an uninitialized proxy. This topic is discussed here.

A proxy can be unproxied via Hibernate.unproxy(). This method is available starting with Hibernate 5.2.10.

Key points:

fetch a proxy via JpaRepository#getOne()
unproxy the fetched proxy via Hibernate.unproxy()
 * 
 * 
 */
