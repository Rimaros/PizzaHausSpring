package ru.springproject.pizza.pools;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Pizza;
import ru.springproject.pizza.interfaces.PizzaPool;

import java.util.HashMap;

@Component
public class Pizzas implements PizzaPool {
    private final HashMap<String, Pizza> pizzaList = new HashMap<>();

    @Bean
    public Pizzas listPizzas() {
        return new Pizzas();
    }

    public Pizzas() {
    }

    @Override
    public HashMap<String, Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizza(Pizza pizza) {
        if (pizza != null) {
            String pizzaName = pizza.getName();
            int numberPizza = 1;
            boolean pizzaFlag = Boolean.FALSE;

            while (!pizzaFlag) {
                if (pizzaList.containsKey(pizzaName)) {
                    pizzaName = pizza.getName();
                    pizzaName += "_" + numberPizza;
                    numberPizza++;
                } else {
                    pizzaFlag = Boolean.TRUE;
                }
            }
            pizza.setName(pizzaName);
            pizzaList.put(pizzaName, pizza);
        }
    }

    public void show() {
        for (String name : pizzaList.keySet()) {
            pizzaList.get(name).showPizza();
        }
    }
}
