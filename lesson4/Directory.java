package ru.gb.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Directory {
    private Set<Employee> directory;

    public Directory(Set<Employee> directory) {
        this.directory = directory;
    }

    public List<Employee> getEmployeeByExperience(double experience) {
        List<Employee> res = new ArrayList<>();

        for (Employee e : directory) {
            if (e.getExperience() == experience) {
                res.add(e);
            }
        }
        return res;
    }

    public List<String> getPhoneNumberByName(String name) {
        List<String> res = new ArrayList<>();
        for (Employee e : directory) {
            if (e.getName().equals(name)) {
                String data = e.getName() + " " + e.getPhoneNumber();
                res.add(data);
            }
        }
        return res;
    }

    public void addEmployee(Employee e) {
        for (Employee employee : directory) {
            if (employee.getID().equals(e.getID())) {
                throw new IllegalArgumentException("Такой ID уже существует!");
            } else {
                directory.add(e);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Employee e : directory) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}
