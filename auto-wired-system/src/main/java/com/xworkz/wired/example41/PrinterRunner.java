package com.xworkz.wired.example41;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrinterRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Printer printer = context.getBean(Printer.class);

        printer.setBrand("Canon");
        printer.setModel("PIXMA");
        printer.setWireless(true);
        printer.setCartridge(new Cartridge("Black", 300, "Ink"));

        System.out.println(printer);

        System.out.println("main ended");
    }

}
