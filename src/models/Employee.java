package models;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String date;
    private List<Book> books;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Employee(int id, String firstName, String lastName, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public Employee(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "entity.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", books=" + books +
                '}';
    }

    public static Employee inputEmployee(Scanner scanner) {
        System.out.println("Введите имя сотрудника:");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию сотрудника:");
        String lastName = scanner.nextLine();

        System.out.println("Введите дату (ГГГГ-ММ-ДД):");
        String date = scanner.nextLine();

        return new Employee(firstName, lastName, date);
    }
}
