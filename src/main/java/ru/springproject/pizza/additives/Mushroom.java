package ru.springproject.pizza.additives;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Additive;

@Component
public class Mushroom implements Additive {
    private String name; // наименование
    private String kind; // White Champignon honey mushrooms  boletus  chanterelles
    private String manufacturer; // производитель  Russia, USA, Belarus, Kazakhstan
    private int cutDegree; // степень измельчения (1 - листами, 2 - кубиками, 3 - кусочками)

    @Bean
    public Mushroom mushroomRusWhite() {
        return new Mushroom("Mushrooms", "white", "'Russia'", 1);
    }

    public Mushroom() {
    }

    public Mushroom(String name, String kind, String manufacturer, int cutDegree) {
        this.name = name;
        this.kind = kind;
        this.manufacturer = manufacturer;
        this.cutDegree = cutDegree;
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
