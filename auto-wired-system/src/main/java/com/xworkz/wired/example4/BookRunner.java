package com.xworkz.wired.example4;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Book book = context.getBean(Book.class);
        book.setTitle("Java Programming");
        book.setPages(450);
        book.setPrice(500);
        book.setAuthor(new Author("John Doe", 45, "American"));

        System.out.println(book);

        System.out.println("main ended");
    }
}
