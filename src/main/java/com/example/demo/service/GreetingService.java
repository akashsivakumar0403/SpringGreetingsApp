package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;
    public Greeting getSimpleGreeting() {
        return new Greeting(0, "Hello World");
    }


    }
