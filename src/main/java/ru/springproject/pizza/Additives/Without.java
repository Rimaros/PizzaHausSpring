package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class Without implements Additive {

    private String name; // наименование

    @Bean
    public Without withOut(){
        return new Without("no additives");
    }

    public Without(){}

    public Without(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeAdditive() {
        System.out.println(name);
    }
}
