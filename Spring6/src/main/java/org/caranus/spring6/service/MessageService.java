package org.caranus.spring6.service;

import org.caranus.spring6.aspect.Countable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{

    @Value("${app.message}")
    private String message;

//  @Autowired
    public MessageService(){
        super();
    }

//    @Loggable
    @Countable
    public String getMessage(String name){
        return message + " " + name;
    }
}
