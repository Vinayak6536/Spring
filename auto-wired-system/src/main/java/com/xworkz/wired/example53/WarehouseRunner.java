package com.xworkz.wired.example53;

import com.xworkz.wired.config.WireConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WarehouseRunner {
    public static void main(String[] args) {
        System.out.println("main started");

        ApplicationContext context = new AnnotationConfigApplicationContext(WireConfiguration.class);
        Warehouse warehouse = context.getBean(Warehouse.class);

        warehouse.setName("Amazon Warehouse");
        warehouse.setCity("Hyderabad");
        warehouse.setWorkers(800);
        warehouse.setStorageUnit(new StorageUnit(5, 2000, false));

        System.out.println(warehouse);

        System.out.println("main ended");
    }
}
