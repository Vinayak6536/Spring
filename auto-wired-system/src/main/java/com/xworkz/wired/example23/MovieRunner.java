package com.xworkz.wired.example23;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Movie movie = context.getBean(Movie.class);

        movie.setTitle("Avengers");
        movie.setGenre("Action");
        movie.setBudget(30000000);
        movie.setActor(new Actor("Robert Downey Jr.", 58, "Iron Man"));

        System.out.println(movie);

        System.out.println("main ended");
    }
}
