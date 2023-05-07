package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
        Human h = (Human) ctx.getBean("vasyl");

        h.talk();
        h.setName("Tatyana");

        /* Scope: singleton, prototype, request, session, global-session, simple-tread */
        Human h1 = (Human) ctx.getBean("vasyl");
        h1.talk();

        System.out.println("Human " + h1.getName() + " has iq = " + h1.getHead().getIq());

        Cat cat = (Cat) ctx.getBean("cat");
        System.out.println("Cat name is " + cat.getName());

        Parrot parrot = (Parrot) ctx.getBean("parrot");
        System.out.println("Parrot name is " + parrot.getName());
        System.out.println("Parrot " + parrot.getName() + " has iq = " + parrot.getHead().getIq());

        ctx.registerShutdownHook();

        AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(MyConfig.class);
        Human h2 = (Human) ctx2.getBean(Human.class);
        
        Integer [] arr = {500,400,300,200,100};
		Arrays.stream(arr).filter(x->x>2).map(x->x/10).sorted().limit(3).forEach(System.out::println);
    }
}
