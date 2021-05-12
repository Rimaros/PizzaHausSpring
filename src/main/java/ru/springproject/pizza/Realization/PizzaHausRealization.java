package ru.springproject.pizza.Realization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaHausRealization {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        MainForm form1 = (MainForm) context.getBean("form1");
        form1.show();

    }
}
