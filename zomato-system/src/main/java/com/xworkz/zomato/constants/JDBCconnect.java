package com.xworkz.zomato.constants;

public enum JDBCconnect {
    URL("jdbc:mysql://localhost:3306/xworkz"),
    USERNAME("root"),
    PASSWORD("Vina@2002");

    private String value;

    JDBCconnect(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
