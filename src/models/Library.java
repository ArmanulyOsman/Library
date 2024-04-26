package models;

import exceptions.BookIsTakenException;
import exceptions.DublicateBookException;
import exceptions.DublicateEmployeeException;
import exceptions.DublicateReaderException;

import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private List<Reader> readers;
    private List<Employee> employees;

    public Library(List<Book> books, List<Reader> readers, List<Employee> employees) {
        this.books = books;
        this.readers = readers;
        this.employees = employees;
    }

    public void addBookToLibrary(Book book, int bookId) {
        try {
            for (Book book1 : books) {
                if (book.equals(book1)) {
                    throw new DublicateBookException("Book alreadey exist!");
                }
            }
        } catch (DublicateBookException exception) {
            System.out.println("Book alreadey exist!");
            return;
        }
        book.setId(bookId);
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Book findBook(Scanner scanner) {
        System.out.println("entity.Book name: ");
        String name = scanner.next();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public Reader findReader(Scanner scanner) {
        System.out.println("entity.Reader first name: ");
        String firstMame = scanner.next();
        for (Reader reader : readers) {
            if (reader.getFirstName().equals(firstMame)) {
                return reader;
            }
        }
        return null;
    }

    public Employee findEmployee(Scanner scanner) {
        System.out.println("entity.Employee first name: ");
        String firstMame = scanner.next();
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstMame)) {
                return employee;
            }
        }
        return null;
    }

    public void addReader(Reader reader, int readerId) {
        try {
            for (Reader reader1 : readers) {
                if (reader1.equals(reader)) {
                    throw new DublicateReaderException("Such a reader exists!");
                }
            }

        } catch (DublicateReaderException exception) {
            System.out.println("Such a reader exists!");
            return;
        }
        reader.setId(readerId);
        readers.add(reader);
    }

    public void deleteReader(Reader reader) {
        readers.remove(reader);
    }

    public void addEmployee(Employee employee, int employeeId) {
        try {
            for (Employee employee1 : employees) {
                if (employee.equals(employee1)) {
                    throw new DublicateEmployeeException("Such a employee exists");
                }
            }
        } catch (DublicateEmployeeException exception) {
            System.out.println("Such a employee exists");
            return;
        }
        employee.setId(employeeId);
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void giveBook(Book book, Reader reader, Employee employee) {
        try {
            if (book.isFlag()) {
                throw new BookIsTakenException("Another reader took the book");
            }
        } catch (BookIsTakenException bookIsTakenException) {
            System.out.println("Book busy!");
            return;
        }

        this.readers.remove(reader);
        this.employees.remove(employee);

        List<Book> takenBooks = reader.getBooks();
        takenBooks.add(book);
        reader.setBooks(takenBooks);

        List<Book> givenBooks = employee.getBooks();
        givenBooks.add(book);
        reader.setBooks(givenBooks);

        book.setFlag(true);

        this.readers.add(reader);
        this.employees.add(employee);
    }

    public void returnBook(Book book, Reader reader, Employee employee) {
        this.readers.remove(reader);
        this.employees.remove(employee);

        List<Book> takenBooks = reader.getBooks();
        takenBooks.remove(book);
        reader.setBooks(takenBooks);

        List<Book> givenBooks = employee.getBooks();
        givenBooks.remove(book);
        reader.setBooks(givenBooks);

        book.setFlag(false);

        this.readers.add(reader);
        this.employees.add(employee);
    }
}
