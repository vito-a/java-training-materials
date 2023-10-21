package org.caranus.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.caranus.spring5")
@EnableAspectJAutoProxy
public class ApplicationConfig
{
/*
	@Value("${app.message}")
	private String message;

	@Value("${app.name}")
	private String name;

	@Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
	private boolean is24;

	@Autowired
	private MessageService messageService;

	@Autowired
	private TimeService timeService;

	@Bean
// 	public TimeService timeService () { return new TimeService(is24); }
	public TimeService timeService () {
		return new TimeService();
	}

// @Bean @Profile("!dev") public TimeService timeService () { return new TimeService(true); }
// @Bean @Profile("dev") public TimeService devTimeService () { return new TimeService(false); }

	@Bean
// 	public OutputService outputService(String name) { return new OutputService(messageService, timeService, name);	}
	public OutputService outputService() {
		return new OutputService(messageService, timeService);
	}

	@Bean
// 	public MessageService messageService() { return new MessageService(message); }
	public MessageService messageService() {
		return new MessageService();
	}

*/
}
