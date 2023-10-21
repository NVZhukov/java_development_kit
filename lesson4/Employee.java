package ru.gb.lesson4;

import java.util.Objects;

public class Employee {
    private String ID;
    private String phoneNumber;
    private String name;
    private double experience;

    public Employee(String ID, String phoneNumber, String name, double experience) {
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public double getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ID='").append(ID).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", experience='").append(experience).append('\'');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.experience, experience) == 0 && ID.equals(employee.ID) && phoneNumber.equals(employee.phoneNumber) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, phoneNumber, name, experience);
    }
}
