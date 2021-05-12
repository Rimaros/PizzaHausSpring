package ru.springproject.pizza.Additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.Interfaces.Additive;

@Component
public class Cervelat implements Additive {

    private String name; // наименование
    private String manufacturer; // производитель Welcome
    private String kind; // cognac / Finnish
    private int cutDegree; // степень измельчения (1 - кружочками, 2 - кусочками)

    @Bean
    public Cervelat cervelatCognakRound(){
        return new Cervelat("Cervelat","Welcome", "cognac", 1);
    }

    public Cervelat(){}

    public Cervelat(String name, String manufacturer, String kind, int cutDegree) {
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
