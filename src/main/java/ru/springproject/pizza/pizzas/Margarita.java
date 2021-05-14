package ru.springproject.pizza.pizzas;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Pizza;

import java.util.ArrayList;

@Component
public class Margarita implements Pizza {


    private String name; // наименование
    private String doughWidth; // уровень толщины теста wide or thin
    private int size; // размер пиццы
    private int count; // количество однотипных пицц
    String info;
    private final ArrayList<String> additionals = new ArrayList<>();

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Margarita margaritaPizza() {
        return new Margarita("Margarita", doughWidth, size, count);
    }

    public Margarita() {
    }

    public Margarita(String name, String doughWidth, int size, int count) {
        this.name = name;
        this.doughWidth = doughWidth;
        this.size = size;
        this.count = count;
    }

    public void setDoughWidth(String doughWidth) {
        this.doughWidth = doughWidth;
    }

    public void setSize(int pizzaSize) {
        this.size = pizzaSize;
    }

    public void setCount(int pizzaCount) {
        this.count = pizzaCount;
    }

    @Override
    public void setName(String pizzaName) {
        this.name = pizzaName;
    }

    @Override
    public void setAdditional(String additional) {
        additionals.add(additional);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void showPizza() {// сделать по аналогии с мясной и Meat

        StringBuilder pizzaAdditives = new StringBuilder();
        StringBuilder pizzaMiddleOrder = new StringBuilder();
        String namePizzaForOrder;

        pizzaAdditives.append(" with ");
        for (String additive : additionals) {
            pizzaAdditives.append(additive).append(", ");
        }
        pizzaAdditives.deleteCharAt(pizzaAdditives.lastIndexOf(", "));

        if (name.contains("_")) namePizzaForOrder = name.split("_")[0];
        else namePizzaForOrder = name;

        pizzaMiddleOrder.append(count)
                .append(" ")
                .append(namePizzaForOrder)
                .append(" pizza with size ")
                .append(size)
                .append(" , dough width ")
                .append(doughWidth)
                .append(pizzaAdditives);

        info = pizzaMiddleOrder.toString();
    }


    @Override
    public void takePizza() {// сделать по аналогии с мясной и Meat

        StringBuilder finalAdditive = new StringBuilder();
        finalAdditive.append("You change Pizza ")
                .append(name)
                .append(" with dough width level: ")
                .append(doughWidth)
                .append(" and size ")
                .append(size)
                .append(".\n");

        System.out.println(finalAdditive.toString());
    }
}
