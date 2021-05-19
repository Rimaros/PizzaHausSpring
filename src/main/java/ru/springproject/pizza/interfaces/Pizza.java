package ru.springproject.pizza.interfaces;

public interface Pizza {

    String getName();

    String getInfo();

    void setName(String pizzaName);

    void setAdditional(String additional);

    void showPizza();

    void takePizza();

    void setCount(int pizzaCount);

    void setSize(int pizzaSize);

    void setDoughWith(String enterDoughWidth);
}
