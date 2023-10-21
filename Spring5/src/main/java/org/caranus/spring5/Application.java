package org.caranus.spring5;

import org.caranus.spring5.aspect.Loggable;
import org.caranus.spring5.config.ApplicationConfig;
import org.caranus.spring5.service.OutputService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    @Value("${app.delay}")
    private static long delay;

    @Loggable
    public static void main(String[] args) throws Exception {
        /*
        MessageService messageService = new MessageService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(messageService, timeService);
        */
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i=0; i<5; i++) {
            outputService.generateOutput();
            Thread.sleep(delay);
        }
    }
}
