package com.xworkz.personalloan.dao.impl;

import com.xworkz.personalloan.constants.JDBCconnect;
import com.xworkz.personalloan.dao.PersonalLoanDao;
import com.xworkz.personalloan.dto.PersonalLoanDto;
import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@ToString
@Component
public class PersonalLoanDaoImpl implements PersonalLoanDao {
    public PersonalLoanDaoImpl(){
        System.out.println("PersonalLoanDaoImpl Invoked....");
    }
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public boolean save(PersonalLoanDto personalLoanDto) {
boolean isValid=false;
        String insert = "insert into personalloan(name,surname,gender,dob,adharno,phoneno,email,maritalstatus,address) values(?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, personalLoanDto.getName());
            preparedStatement.setString(2, personalLoanDto.getSurName());
            preparedStatement.setString(3, String.valueOf(personalLoanDto.getGender()));
            preparedStatement.setString(4, personalLoanDto.getDob());
            preparedStatement.setLong(5, personalLoanDto.getAdharNO());
            preparedStatement.setLong(6, personalLoanDto.getPhoneNo());
            preparedStatement.setString(7, personalLoanDto.getEmail());
            preparedStatement.setString(8, personalLoanDto.getMaritalStatus());
            preparedStatement.setString(9, personalLoanDto.getAddress());

            int row=preparedStatement.executeUpdate();
            System.out.println(row +" "+"Rows Affected");

            isValid=true;

        }


        return isValid;
    }
}
