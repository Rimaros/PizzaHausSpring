package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class Pickles implements Additive {

    private String name; // наименование
    private String manufacturer; // производитель Pickles Company ltd.
    private int salinityLevel; // уровень солености
    private int cutDegree; // степень измельчения (1 - листами, 2 - кружочками, 3 - кусочками)

    @Bean
    public Pickles picklesPcRound() {
        return new Pickles("Pickles", "'Pickles Company ltd.'", 4, 2);
    }

    public Pickles() {
    }

    public Pickles(String name, String manufacturer, int sweetnessLevel, int cutDegree) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.salinityLevel = sweetnessLevel;
        this.cutDegree = cutDegree;
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
                .append(" with salinity level ")
                .append(salinityLevel)
                .append(" and slicing ")
                .append(cutDegree)
                .append(".");

        System.out.println(finalAdditive.toString());
    }
}
