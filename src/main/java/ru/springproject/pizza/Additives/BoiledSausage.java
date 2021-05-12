package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class BoiledSausage implements Additive {

    private String name; // наименование
    private String manufacturer; // производитель Welcome
    private String kind; // boiled / doctor's
    private int cutDegree; // степень измельчения (1 - кружочками, 2 - кусочками)

    @Bean
    public BoiledSausage boiledSausageDocPieces(){
        return new BoiledSausage("Boiled sausage","Welcome", "doctor's", 2);
    }

    public BoiledSausage(){}

    public BoiledSausage(String name, String manufacturer, String kind, int cutDegree) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.kind = kind;
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
                .append(" ")
                .append(kind)
                .append(" from ")
                .append(manufacturer)
                .append(" with slicing ")
                .append(cutDegree)
                .append(".");

        System.out.println(finalAdditive.toString());
    }
}
