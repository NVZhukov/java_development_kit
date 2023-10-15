package ru.gb.lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(13L, 22.1));
        System.out.println(Calculator.multiply(13, 22f));
        System.out.println(Calculator.divide(12, 25f));
        System.out.println(Calculator.subtract(13L, 22.222));

        Object[] arr1 = {1, 2, 3, 4, 5};
        String[] arr2 = {"aa", "ax", "ac", "ab", "bb"};
        Object[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(compareArrays(arr1, arr2));

        Pair<String, Integer> pair = new Pair<>("Hi",12);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);
    }


    /*Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
    если они одинаковые, и false в противном случае.
    Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
     */

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
