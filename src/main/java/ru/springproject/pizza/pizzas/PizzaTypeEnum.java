package ru.springproject.pizza.pizzas;

import ru.springproject.pizza.exception.NoSuchPizzaException;
import ru.springproject.pizza.interfaces.Pizza;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum PizzaTypeEnum {
    CARBONARA(1, new Carbonara()),
    HUNTING(2, new Hunting()),
    MARGARITA(3, new Margarita()),
    MEAT(4, new Meat());

    int num;
    Pizza pizza;

    PizzaTypeEnum(int i, Pizza pizzaClass) {

    }


    public static Pizza getPizzaByCode(int pizzaCode) {
        Optional<PizzaTypeEnum> pizzaTypeEnum1 = Arrays.stream(PizzaTypeEnum.values()).findFirst().filter(pizzaTypeEnum -> pizzaTypeEnum.num == pizzaCode);
        if (pizzaTypeEnum1.isPresent()) {
            return pizzaTypeEnum1.get().pizza;
        } else {
            throw new NoSuchPizzaException("Нет пиццы с кодом " + pizzaCode);
        }
    }
}
