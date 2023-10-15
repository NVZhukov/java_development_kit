package ru.gb.lesson3;

public class Calculator {

    public static <T extends Number> Number sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> Number multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> Number divide(T num1, T num2) {
        if (num2.doubleValue() == 0) throw new ArithmeticException("Деление на ноль");
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number> Number subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
