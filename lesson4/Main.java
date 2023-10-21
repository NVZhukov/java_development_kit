package ru.gb.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = generateList();
        CopyOnWriteArraySet<Employee> list = new CopyOnWriteArraySet<>(employees);
        Directory directory = new Directory(list);

        System.out.println(directory);
        System.out.println(directory.getEmployeeByExperience(5));
        System.out.println(directory.getPhoneNumberByName("Игорь"));
        directory.addEmployee(new Employee("18","111222", "Виктор", 2));
        System.out.println(directory);
    }

    public static List<Employee> generateList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("11","12345","Матвей", 5));
        list.add(new Employee("12","54321","Игорь", 1));
        list.add(new Employee("21","5432111","Игорь", 3));
        list.add(new Employee("13","45643","Екатерина", 3.5));
        list.add(new Employee("14","68587","Ольга", 12));
        list.add(new Employee("15","231243","Павел", 5));
        list.add(new Employee("15","231243","Павел", 5));
        return list;
    }
}
