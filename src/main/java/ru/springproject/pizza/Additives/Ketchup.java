package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class Ketchup implements Additive {

    private String name; // наименование
    private String manufacturer; // производитель Heinz Baltimor
    private int spiceLevel; // уровень остроты

    @Bean
    public Ketchup ketchupHeinz(){
        return new Ketchup("ketchup Heinz","'Heinz'",3);
    }

    public Ketchup(){}

    public Ketchup(String name, String manufacturer, int sweetnessLevel) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.spiceLevel = sweetnessLevel;
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
                .append(" with ")
                .append(spiceLevel)
                .append(" intensity of spice.");

        System.out.println(finalAdditive.toString());
    }
}
