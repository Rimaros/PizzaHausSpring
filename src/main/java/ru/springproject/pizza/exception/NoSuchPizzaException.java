package ru.springproject.pizza.exception;

public class NoSuchPizzaException extends RuntimeException {
    public NoSuchPizzaException(String message) {
        super(message);
    }
}
