import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> libraryBooks = new ArrayList<>();
        libraryBooks.add(new Book(1L, "Путь к мудрости", 2020, "Иван Иванов", 300, false, Genre.FANTASY));
        libraryBooks.add(new Book(2L, "Летопись времени", 2018, "Анна Петрова", 450, false, Genre.BIOGRAPHY));
        libraryBooks.add(new Book(3L, "Кодовое имя: Спасение", 2022, "Павел Сидоров", 380, false, Genre.HORROR));
        libraryBooks.add(new Book(4L, "Путешествие во времени", 2015, "Елена Смирнова", 250, false, Genre.FANTASY));
        libraryBooks.add(new Book(5L, "Сила созидания", 2019, "Мария Кузнецова", 400, false, Genre.DETECTIVE));

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader(1, "Elon", "Mask", 12345, "2022-01-15"));
        readers.add(new Reader(2, "Andrew", "Tate", 12345, "2022-01-15"));
        readers.add(new Reader(3, "Gennadiy", "Golovkin", 12345, "2022-01-15"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Brad", "Pitt", "2021-03-21"));
        employees.add(new Employee(2L, "Margot", "Robbie", "2021-03-21"));
        employees.add(new Employee(3L, "Martin", "Scorsese", "2021-03-21"));

        Library library = new Library(libraryBooks, readers, employees);
        Scanner scanner = new Scanner(System.in);
        String operation;

        while (true){
            operation = scanner.nextLine();

            switch (operation) {
                case "addBook":
                    Book book = Book.createBookFromConsole(scanner);
                    library.addBookToLibrary(book);
                    break;
                case "deleteBook":
                    library.deleteBook(library.findBook(scanner));
                    break;
                case "findBook":
                    library.findBook(scanner);
                    break;
                case "addReader":
                    library.addReader(Reader.inputReader(scanner), readers.size()+1);
                    break;
                case "deleteReader":
                    library.deleteReader(library.findReader(scanner));
                    break;
                case "addEmployee":
                    library.addEmployee(Employee.inputEmployee(scanner));
                    break;
                case "deleteEmployee":
                    library.deleteEmployee(library.findEmployee(scanner));
                    break;
                case "giveBook":
                    library.giveBook(library.findBook(scanner), library.findReader(scanner), library.findEmployee(scanner));
                    break;
                case "returnBook":
                    library.returnBook(library.findBook(scanner), library.findReader(scanner), library.findEmployee(scanner));
                    break;
                case "All books":
                    for (Book libraryBook : library.getBooks()) {
                        System.out.println(libraryBook.toString());
                    }
                    break;
                case "All employees":
                    for (Employee employee : library.getEmployees()) {
                        System.out.println(employee.toString());
                    }
                    break;
                case "All readers":
                    for (Reader reader : library.getReaders()) {
                        System.out.println(reader.toString());
                    }
                    break;
                case "-1":
                    return;
                default:
                    System.out.println("Unknown operation");
            }
        }
    }
}