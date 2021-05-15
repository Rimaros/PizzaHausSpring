package ru.springproject.pizza.realization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.springproject.pizza.additives.*;
import ru.springproject.pizza.interfaces.Form;
import ru.springproject.pizza.pizzas.Carbonara;
import ru.springproject.pizza.pizzas.Hunting;
import ru.springproject.pizza.pizzas.Margarita;
import ru.springproject.pizza.pizzas.Meat;
import ru.springproject.pizza.pools.Pizzas;

import java.io.*;

@Component
public class MainForm implements Form {
    //Additives

    private BellPepper bellPepperMex;
    private JalapenaPepper jalapenaPepperUsa;
    private BoiledSausage boiledSausageDocPieces;
    private Cervelat cervelatCognakRound;
    private Ketchup ketchupHeinz;
    private Mayonnaise mayonnaiseAinStandart;
    private Mushroom mushroomRusWhite;
    private Olives olivesGreekGreen;
    private Pickles picklesPcRound;
    private Without withOut;

    // Pizzas
    private Carbonara carbonaraPizza;
    private Hunting huntingPizza;
    private Margarita margaritaPizza;
    private Meat meatPizza;

    // Pizzas Pool
    private Pizzas listPizzas;

    // Pizzas parameters
    private String enterDoughWidth;
    private int pizzaSize;
    private String pizzaName;
    private int pizzaCount;

    // Autowired's of Additives
    @Autowired
    public void setBellPepper(BellPepper bellPepperMex) {
        this.bellPepperMex = bellPepperMex;
    }

    @Autowired
    public void setJalapenaPepper(JalapenaPepper jalapenaPepperUsa) {
        this.jalapenaPepperUsa = jalapenaPepperUsa;
    }

    @Autowired
    public void setBoiledSausage(BoiledSausage boiledSausageDocPieces) {
        this.boiledSausageDocPieces = boiledSausageDocPieces;
    }

    @Autowired
    public void setCervelat(Cervelat cervelatCognakRound) {
        this.cervelatCognakRound = cervelatCognakRound;
    }

    @Autowired
    public void setKetchup(Ketchup ketchupHeinz) {
        this.ketchupHeinz = ketchupHeinz;
    }

    @Autowired
    public void setMayonnaise(Mayonnaise mayonnaiseAinStandart) {
        this.mayonnaiseAinStandart = mayonnaiseAinStandart;
    }

    @Autowired
    public void setMushroom(Mushroom mushroomRusWhite) {
        this.mushroomRusWhite = mushroomRusWhite;
    }

    @Autowired
    public void setOlives(Olives olivesGreekGreen) {
        this.olivesGreekGreen = olivesGreekGreen;
    }

    @Autowired
    public void setPickles(Pickles picklesPcRound) {
        this.picklesPcRound = picklesPcRound;
    }

    @Autowired
    public void setWithout(Without withOut) {
        this.withOut = withOut;
    }

    // Autowired's of Pizzas
    @Autowired
    public void setCarbonara(Carbonara carbonaraPizza) {
        this.carbonaraPizza = carbonaraPizza;
    }

    @Autowired
    public void setHunting(Hunting huntingPizza) {
        this.huntingPizza = huntingPizza;
    }

    @Autowired
    public void setMargarita(Margarita margaritaPizza) {
        this.margaritaPizza = margaritaPizza;
    }

    @Autowired
    public void setMeat(Meat meatPizza) {
        this.meatPizza = meatPizza;
    }

    // Autowired's of Pools
    @Autowired
    public void setPizzaPool(Pizzas listPizzas) {
        this.listPizzas = listPizzas;
    }

    @Bean
    public MainForm form1() {
        return new MainForm();
    }

    public MainForm() {
    }

    @Override
    public void show() {
        System.out.println("Hello! It is Pizza House!");

        try (Reader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            startShow(bufferedReader);
            finalShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startShow1(BufferedReader bufferedReader) {
    }

    private void startShow(BufferedReader bufferedReader) {
        String orderWord;
        boolean orderFlag = Boolean.FALSE;
        boolean orderRepeat = Boolean.FALSE;

        while (!orderFlag) {
            if (orderRepeat) {
                System.out.println("Add Pizza to Order? (yes or no)");
            } else {
                System.out.println("Would you like take a pizza? (yes or no)");
            }

            try {
                orderWord = bufferedReader.readLine(); //читаем строку с клавиатуры
                if ("yes".equalsIgnoreCase(orderWord)) {
                    orderRepeat = Boolean.TRUE;

                    checkCount(bufferedReader);
                    checkSize(bufferedReader);
                    checkDoughWidth(bufferedReader);
                    checkType(bufferedReader);
                    checkAdditives(bufferedReader);

                } else if ("no".equalsIgnoreCase(orderWord)) {
                    orderFlag = Boolean.TRUE;
                } else {
                    System.out.println("Please change from 'yes' or 'no'!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCount(BufferedReader bufferedReader) {
        String enterCount;
        boolean pizzaCountFlag = Boolean.FALSE;

        while (!pizzaCountFlag) {
            System.out.println("Enter the number of pizzas (1-50):");

            try {
                enterCount = bufferedReader.readLine(); //читаем строку с клавиатуры
                if (enterCount.matches("[0-9]+")) {
                    pizzaCount = Integer.parseInt(enterCount); //преобразовываем строку в число.
                    System.out.println(pizzaCount);
                    if (pizzaCount > 0 && pizzaCount < 51){
                        pizzaCountFlag = Boolean.TRUE;
                    } else {
                        System.out.println("This count is not correctly!\n");
                    }
                } else {
                    System.out.println("It is not number, fool!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkSize(BufferedReader bufferedReader) {
        String enterSize;
        boolean pizzaSizeFlag = Boolean.FALSE;

        while (!pizzaSizeFlag) {
            System.out.println("Enter size of Pizza (10-50 sm):");

            try {
                enterSize = bufferedReader.readLine(); //читаем строку с клавиатуры
                if (enterSize.matches("[0-9]+")) {
                    pizzaSize = Integer.parseInt(enterSize); //преобразовываем строку в число.
                    System.out.println(pizzaSize);
                    if (pizzaSize > 10 && pizzaSize < 51) {
                        pizzaSizeFlag = Boolean.TRUE;
                    } else {
                        System.out.println("This size is not correctly!\n");
                    }
                } else {
                    System.out.println("It is not pizza size, fool!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkDoughWidth(BufferedReader bufferedReader) {
        boolean pizzaDoughWidthFlag = Boolean.FALSE;

        while (!pizzaDoughWidthFlag) {
            System.out.println("Enter dough width of Pizza (wide or thin):");

            try {
                enterDoughWidth = bufferedReader.readLine(); //читаем строку с клавиатуры
                if ("wide".equalsIgnoreCase(enterDoughWidth) || "thin".equalsIgnoreCase(enterDoughWidth)) {
                    System.out.println(enterDoughWidth);
                    pizzaDoughWidthFlag = Boolean.TRUE;
                } else {
                    System.out.println("Please change from 'wide' or 'thin'!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkType(BufferedReader bufferedReader) {
        String enterType;
        int changeType;
        boolean pizzaTypeFlag = Boolean.FALSE;

        while (!pizzaTypeFlag) {
            System.out.println("Enter type of Pizza (1-4):");
            System.out.println("1 - Carbonara");
            System.out.println("2 - Hunting");
            System.out.println("3 - Margarita");
            System.out.println("4 - Meat");

            try {
                enterType = bufferedReader.readLine(); //читаем строку с клавиатуры
                if (enterType.matches("[1-4]")) {
                    changeType = Integer.parseInt(enterType); //преобразовываем строку в число.
                    System.out.println(changeType);

                    switch (changeType) {
                        case 1:
// это надо переписать!
// т.к. каждый case делает ОДНО И Т ОЖЕ!
// ты можешь это дело вынести в отдельный метод и вызывать его в case с параметром "конкретный клас"
                            // private Pizza pizza(Pizza pizza);
                            // carbonaraPizza = preparePizza(carbonaraPizza.carbonaraPizza());
                            // в общем, должен быть только вызов одного метода, и написанный он должен быть:
                            // либо через интерфейс Pizza
                            // либо через дженерик
                            // смотри как тебе приятнее повыпендриваться
                            carbonaraPizza = carbonaraPizza.carbonaraPizza();
                            carbonaraPizza.setDoughWidth(enterDoughWidth);
                            carbonaraPizza.setSize(pizzaSize);
                            carbonaraPizza.setCount(pizzaCount);
                            listPizzas.setPizza(carbonaraPizza);
                            carbonaraPizza.takePizza();
                            pizzaName = carbonaraPizza.getName();
                            break;
                        case 2:
                            huntingPizza = huntingPizza.huntingPizza();
                            huntingPizza.setDoughWidth(enterDoughWidth);
                            huntingPizza.setSize(pizzaSize);
                            huntingPizza.setCount(pizzaCount);
                            listPizzas.setPizza(huntingPizza);
                            huntingPizza.takePizza();
                            pizzaName = huntingPizza.getName();
                            break;
                        case 3:
                            margaritaPizza = margaritaPizza.margaritaPizza();
                            margaritaPizza.setDoughWidth(enterDoughWidth);
                            margaritaPizza.setSize(pizzaSize);
                            margaritaPizza.setCount(pizzaCount);
                            listPizzas.setPizza(margaritaPizza);
                            margaritaPizza.takePizza();
                            pizzaName = margaritaPizza.getName();
                            break;
                        case 4:
                            meatPizza = meatPizza.meatPizza();
                            meatPizza.setDoughWidth(enterDoughWidth);
                            meatPizza.setSize(pizzaSize);
                            meatPizza.setCount(pizzaCount);
                            listPizzas.setPizza(meatPizza);
                            meatPizza.takePizza();
                            pizzaName = meatPizza.getName();
                            break;
                        default:
                            System.out.println("This type of pizza lost!");
                            break;
                    }
                    pizzaTypeFlag = Boolean.TRUE;
                } else System.out.println(enterType + " is not correctly type!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkAdditives(BufferedReader bufferedReader) {
        String enterAdditives;
        String[] masEnterAdditives;
        boolean pizzaTypeFlag = Boolean.FALSE;
        String additiveName = "";

        while (!pizzaTypeFlag) {
            System.out.println("Get additives to Pizza (0-9). Change numbers and set ';' between :");
            System.out.println("0 - without");
            System.out.println("1 - olives");
            System.out.println("2 - cervelat");
            System.out.println("3 - pickles");
            System.out.println("4 - mushrooms");
            System.out.println("5 - boiled sausage");
            System.out.println("6 - ketchup");
            System.out.println("7 - mayonnaise");
            System.out.println("8 - bell pepper");
            System.out.println("9 - jalapena pepper");

            try {
                enterAdditives = bufferedReader.readLine(); //читаем строку с клавиатуры
                if (enterAdditives.matches("[0-9]") || enterAdditives.contains(";")) {

                    if (enterAdditives.contains("0;") || enterAdditives.contains(";0") ||
                            (enterAdditives.contains("0") & enterAdditives.length() == 1)) {
                        enterAdditives = enterAdditives.replaceAll("[^0]", "");
                    }

                    if (!enterAdditives.contains(";")) {
                        masEnterAdditives = new String[]{enterAdditives};
                    } else {
                        masEnterAdditives = enterAdditives.split(";");
                    }

                    for (String masEnterAdditivesElement : masEnterAdditives) {
                        switch (masEnterAdditivesElement) {
                            case "0":
                                withOut.takeAdditive();
                                additiveName = withOut.getName();
                                break;
                            case "1":
                                olivesGreekGreen.takeAdditive();
                                additiveName = olivesGreekGreen.getName();
                                break;
                            case "2":
                                cervelatCognakRound.takeAdditive();
                                additiveName = cervelatCognakRound.getName();
                                break;
                            case "3":
                                picklesPcRound.takeAdditive();
                                additiveName = picklesPcRound.getName();
                                break;
                            case "4":
                                mushroomRusWhite.takeAdditive();
                                additiveName = mushroomRusWhite.getName();
                                break;
                            case "5":
                                boiledSausageDocPieces.takeAdditive();
                                additiveName = boiledSausageDocPieces.getName();
                                break;
                            case "6":
                                ketchupHeinz.takeAdditive();
                                additiveName = ketchupHeinz.getName();
                                break;
                            case "7":
                                mayonnaiseAinStandart.takeAdditive();
                                additiveName = mayonnaiseAinStandart.getName();
                                break;
                            case "8":
                                bellPepperMex.takeAdditive();
                                additiveName = bellPepperMex.getName();
                                break;
                            case "9":
                                jalapenaPepperUsa.takeAdditive();
                                additiveName = jalapenaPepperUsa.getName();
                                break;
                            default:
                                System.out.println("This additive - '" + masEnterAdditivesElement + "' for pizza is not correctly!");
                                break;
                        }
                        listPizzas.getPizzaList().get(pizzaName).setAdditional(additiveName);
                    }
                    pizzaTypeFlag = Boolean.TRUE;
                } else {
                    System.out.println(enterAdditives + " is not correctly enter!\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void finalShow() {
        StringBuilder pizzaOrder = new StringBuilder("\nYour order : \n\t");

        if (listPizzas.getPizzaList().isEmpty()) {
            pizzaOrder.append("nothing");
        } else {
            listPizzas.show();
//            for (String pizzaOrderString : listPizzas.getPizzaList().keySet()) {
//                pizzaOrder.append(listPizzas.getPizzaList().get(pizzaOrderString).getInfo())
//                        .append("; \n\t");
//            }
            listPizzas.getPizzaList()
                    .forEach((pizzaOrderString, pizza) -> {
                pizzaOrder
                        .append(pizza.getInfo())
                        .append("; \n\t");
            });
            pizzaOrder.replace(pizzaOrder.lastIndexOf(";"),
                    pizzaOrder.lastIndexOf(";") + 1,
                    ".");
        }
        System.out.println(pizzaOrder.toString());
    }
}


//  size
//  dough width :  wide (широкое) thin(тонкое)

//  вид пиццы   :  type of pizza  (карбонара (состав и т.д.)(carbonara), охотничья(hunting), маргарита(margarita), мясная(meat))

//  Добавки     :  оливки (olives), сервелат (cervelat), огурцы соленые (pickles), грибы (mushrooms), колбаса вареная (boiled sausage),
//                 кетчуп (ketchup), майонез (mayonnaise), перец болгарский (BellPepper), перец халапеньо (jalapena pepper)

// Просим ввести размер, толщину теста, вид пиццы, желаемые добавки