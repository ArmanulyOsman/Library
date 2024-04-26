package models;

import java.util.Objects;
import java.util.Scanner;

public class Book {
    private int id;
    private String name;
    private int year;
    private String author;
    private int pagesCount;
    private boolean flag;
    private Genre genre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    public Book(int id, String name, int year, String author, int pagesCount, boolean flag, Genre genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.pagesCount = pagesCount;
        this.flag = flag;
        this.genre = genre;
    }

    public Book(String name, int year, String author, int pagesCount, boolean flag, Genre genre) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.pagesCount = pagesCount;
        this.flag = flag;
        this.genre = genre;
    }

    public Book(){}

    @Override
    public String toString() {
        return "entity.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", pagesCount=" + pagesCount +
                ", flag=" + flag +
                ", genre=" + genre +
                '}';
    }

    public static Book createBookFromConsole(Scanner scanner) {
        System.out.println("Введите название книги:");
        String name = scanner.nextLine();

        System.out.println("Введите год издания:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите автора:");
        String author = scanner.nextLine();

        System.out.println("Введите количество страниц:");
        int pagesCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите жанр (возможные варианты: FANTASY, DETECTIVE, BIOGRAPHY, LITERATURE, HORROR):");
        String genreInput = scanner.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreInput);

        Book newBook = new Book();
        newBook.setName(name);
        newBook.setYear(year);
        newBook.setAuthor(author);
        newBook.setPagesCount(pagesCount);
        newBook.setGenre(genre);

        scanner.close();

        return newBook;
    }
}
