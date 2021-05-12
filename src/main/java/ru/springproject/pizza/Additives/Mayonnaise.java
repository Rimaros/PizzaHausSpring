package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class Mayonnaise implements Additive {

    private String name; // наименование Московский провансаль(Moscow provencal)  Ряба(Ryaba)
    private String manufacturer; // производитель Moscow Fat Factory (Moscow provencal) / Aintrigud (Ryaba)
    private int type; // тип (1 - стандартный провансаль, 2 - с оливковым)

    @Bean
    public Mayonnaise mayonnaiseAinStandart() {
        return new Mayonnaise("Mayonnaise", "Aintrigud", 1);
    }

    public Mayonnaise() {
    }

    public Mayonnaise(String name, String manufacturer, int type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeAdditive() {

        StringBuilder finalAdditive = new StringBuilder();
        finalAdditive.append("take additional ")
                .append(name)
                .append(" from ")
                .append(manufacturer)
                .append(" type of ")
                .append(type)
                .append(".");

        System.out.println(finalAdditive.toString());
    }
}
