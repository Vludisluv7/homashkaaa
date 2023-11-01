package org.example;

import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    String getDescription();
}

class Book implements LibraryItem, Comparable<LibraryItem> {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return "Book: " + title + " by " + author;
    }

    @Override
    public int compareTo(LibraryItem other) {
        return this.getDescription().compareTo(other.getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return this.getTitle().equals(other.getTitle()) &&
                this.getAuthor().equals(other.getAuthor());
    }
}

class DVD implements LibraryItem {
    private String title;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title;
    }
}

class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void listItems() {
        for (LibraryItem item : items) {
            System.out.println(item.getDescription());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Отцы и дети", "Тургенев");
        DVD dvd = new DVD("AC/DC");

        Library library = new Library();
        library.addItem(book);
        library.addItem(dvd);

        library.listItems();

        // Сравнение элементов
        int comparison = book.compareTo(dvd);
        if (comparison < 0) {
            System.out.println("Книга меньше по описанию, чем DVD");
        } else if (comparison > 0) {
            System.out.println("Книга больше по описанию, чем DVD");
        } else {
            System.out.println("Книга и DVD имеют одинаковое описание");
        }

        // Проверка равенства элементов
        boolean areEqual = book.equals(dvd);
        if (areEqual) {
            System.out.println("Книга и DVD равны");
        } else {
            System.out.println("Книга и DVD не равны");
        }
    }
}