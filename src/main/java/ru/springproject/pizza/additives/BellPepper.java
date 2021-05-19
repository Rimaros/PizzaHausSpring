package ru.springproject.pizza.additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Additive;

@Component
public class BellPepper extends BaseAdditive implements Additive {

    private String color; // зеленый красный желтый
    private int sweetnessLevel; // уровень сладости

    @Bean
    public BaseAdditive bellPepperMex() {
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
        // можно сделать через ту стринг(но это похоже на логику, а логику лучше не писать в ту стринге, можно через
        // и можно через System.out.printf(

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
