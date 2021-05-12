package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class BellPepper implements Additive {

    private String name; // наименование
    private String color; // зеленый красный желтый
    private String manufacturer; // производитель
    private int sweetnessLevel; // уровень сладости

    @Bean
    public BellPepper bellPepperMex() {
        return new BellPepper("Bell pepper", "red", "MexCompany", 4);
    }

    public BellPepper() {
    }

    public BellPepper(String name, String color, String manufacturer, int sweetnessLevel) {
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
        this.sweetnessLevel = sweetnessLevel;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeAdditive() {

        StringBuilder finalAdditive = new StringBuilder();
        finalAdditive.append("take additional ")
                .append(color)
                .append(" ")
                .append(name)
                .append(" from ")
                .append(manufacturer)
                .append(" with ")
                .append(sweetnessLevel)
                .append(" intensity of taste.");

        System.out.println(finalAdditive.toString());
    }
}
