package org.caranus.spring6.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {

    @Value("${app.name}")
    private String name;
    private final MessageService messageService;
    private final TimeService timeService;

//    @Autowired
//    public OutputService(MessageService messageService, TimeService timeService, String name) {
    public OutputService(MessageService messageService, TimeService timeService) {
        this.messageService = messageService;
        this.timeService = timeService;
//        this.name = name;
    }

    public void generateOutput() {
        String output = timeService.getCurrentTime() + " " + messageService.getMessage(name);
        System.out.println(output);
    }

}
