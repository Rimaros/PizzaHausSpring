package ru.springproject.pizza.pizzas;

import com.sun.deploy.util.StringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.interfaces.Pizza;

import java.util.ArrayList;

@Component
public class Meat implements Pizza {
    private String name; // наименование
    private String doughWidth; // уровень толщины теста wide or thin
    private int size; // размер пиццы
    private int count; // количество однотипных пицц
    String info;
    private final ArrayList<String> additionals = new ArrayList<>();

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Meat meatPizza() {
        return new Meat("Meat", doughWidth, size, count);
    }

    public Meat() {
    }

    public Meat(String name, String doughWidth, int size, int count) {
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
    public void showPizza() { // и тут бы я сделал через форматирование а не через Builder
        StringBuilder pizzaMiddleOrder = new StringBuilder();

        pizzaMiddleOrder.append(count)
                .append(" ")
                .append(name.contains("_") ?
                        name.split("_")[0] : name)
                .append(" pizza with size ")
                .append(size)
                .append(" , dough width ")
                .append(doughWidth)
                .append(" with ")
                .append(StringUtils.join(additionals, ", "));

        info = pizzaMiddleOrder.toString();
    }

    @Override
    public void takePizza() { // делать через систем.аут.принтФ()... пример написал но не проверял, протестируй
//        String finalAdditive = "You change Pizza " +
//                name +
//                " with dough width level: " +
//                doughWidth +
//                " and size " +
//                size +
//                ".\n";
//        System.out.println(finalAdditive);
        System.out.printf(
                "You change Pizza %s with dough width level: %s and size %d",
                name,
                doughWidth,
                size);
    }
}
