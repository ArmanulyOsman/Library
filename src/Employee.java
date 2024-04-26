import java.util.List;
import java.util.Scanner;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String date;
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Employee(Long id, String firstName, String lastName, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Employee{" +
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

        // Возвращаем новый экземпляр сотрудника
        return new Employee(null, firstName, lastName, date);
    }
}
