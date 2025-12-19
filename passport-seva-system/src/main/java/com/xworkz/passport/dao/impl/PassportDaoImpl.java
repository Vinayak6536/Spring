package com.xworkz.passport.dao.impl;

import com.xworkz.passport.constants.JDBCconnect;
import com.xworkz.passport.dao.PassportDao;
import com.xworkz.passport.dto.PassportDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
@Component
public class PassportDaoImpl implements PassportDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(PassportDto passportDto) {
        boolean isvalid = false;

        String insert = "insert into passport(firstname,lastname,age,dob,adhar,address) values (?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

           preparedStatement.setString(1, passportDto.getFirstName());
           preparedStatement.setString(2, passportDto.getLastName());
           preparedStatement.setInt(3,passportDto.getAge());
           preparedStatement.setDate(4,passportDto.getDob());
           preparedStatement.setLong(5,passportDto.getAdharNo());
           preparedStatement.setString(6, passportDto.getAddress());

           int row= preparedStatement.executeUpdate();
            System.out.println(row+" "+"Rows Affected");
            isvalid=true;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isvalid;
    }
}
