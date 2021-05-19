package ru.springproject.pizza.realization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootAp
public class PizzaHausRealization {
    public static void main(String[] args) {
//        new ClassPathXmlApplicationContext("context.xml")// возможно нужно взять эту строку в скобки я хз - не помню
//                .getBean("form1")
//                .show();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        (MainForm) context
                .getBean("form1")
                .show();

//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        MainForm form1 = (MainForm) context.getBean("form1");
//        form1.show();
    }
}
