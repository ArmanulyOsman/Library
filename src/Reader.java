import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Reader {
    private int id = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(firstName, reader.firstName) && Objects.equals(lastName, reader.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    private String firstName;
    private String lastName;
    private int ticketNumber;
    private String registrationDate;

    public Reader(String firstName, String lastName, int ticketNumber, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketNumber = ticketNumber;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
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

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ticketNumber=" + ticketNumber +
                ", registrationDate='" + registrationDate + '\'' +
                ", books=" + books +
                '}';
    }

    public Reader(int id, String firstName, String lastName, int ticketNumber, String registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketNumber = ticketNumber;
        this.registrationDate = registrationDate;
    }

    public static Reader inputReader(Scanner scanner) {
        System.out.println("Введите имя читателя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию читателя:");
        String lastName = scanner.nextLine();

        System.out.println("Введите номер билета:");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после nextInt()

        System.out.println("Введите дату регистрации (ГГГГ-ММ-ДД):");
        String registrationDate = scanner.nextLine();

        System.out.println("New reader added");
        return new Reader(firstName, lastName, ticketNumber, registrationDate);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }
    private List<Book> books;
}
