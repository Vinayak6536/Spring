package com.xworkz.wired.example14;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Library library = context.getBean(Library.class);
        library.setName("City Library");
        library.setCity("Chennai");
        library.setBooks(5000);
        library.setBookShelf(new BookShelf(10, "Wood", true));

        System.out.println(library);

        System.out.println("mian ended");
    }
}
