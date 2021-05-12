package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class JalapenaPepper implements Additive {

    private String name; // наименование
    private String manufacturer; // производитель США / мексика
    private int spiceLevel; // уровень остроты

    @Bean
    public JalapenaPepper jalapenaPepperUsa() {
        return new JalapenaPepper("Jalapena pepper", "USA Company", 7);
    }

    public JalapenaPepper() {
    }

    public JalapenaPepper(String name, String manufacturer, int spiceLevel) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.spiceLevel = spiceLevel;
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
