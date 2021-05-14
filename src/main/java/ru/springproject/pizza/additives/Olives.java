package ru.springproject.pizza.additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Additive;

@Component
public class Olives implements Additive {
    private String name; // наименование
    private String color; // зеленый черный
    private String manufacturer; // производитель Greek, Cyprus, Spain

    @Bean
    public Olives olivesGreekGreen() {
        return new Olives("Olives", "green", "'Greek'", 1);
    }

    public Olives() {
    }

    public Olives(String name, String color, String manufacturer, int sweetnessLevel) {
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeAdditive() {
        // можно сделать через ту стринг(но это похоже на логику, а логику лучше не писать в ту стринге, можно через
        // и можно через System.out.printf(
        StringBuilder finalAdditive = new StringBuilder("take additional ")
                .append(color)
                .append(" ")
                .append(name)
                .append(" from ")
                .append(manufacturer)
                .append(".");

        System.out.println(finalAdditive.toString());
    }
}
