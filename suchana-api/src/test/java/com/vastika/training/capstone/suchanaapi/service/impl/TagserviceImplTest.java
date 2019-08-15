package com.vastika.training.capstone.suchanaapi.service.impl;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TagserviceImplTest {

    @Test
    public void testRandom() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        int i = 5; // primitives
        Integer wrapped = i; // auto-boxing

        Integer wrapperI = 5;
        int newI = wrapperI; // unboxing


        String s = "       ";
        System.out.println("Length of s is: " + s.length());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("roshan"));
        System.out.println(encoder.encode("dhiraj"));
        System.out.println(encoder.encode("nabin"));
        System.out.println(encoder.encode("saurav"));
    }

}

