package com.xworkz.file.constant;

public enum JDBCconnect {
    URL("jdbc:mysql://localhost:3306/xworkz"),
    USERNAME("root"),
    PASSWORD("Vina@2002");

    private String value;

    JDBCconnect(String value){
        System.out.println("Running JDBC Connect");
        this.value=value;
    }

    public String  getValue(){
        return value;
    }
}
