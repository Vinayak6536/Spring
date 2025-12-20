package com.xworkz.zomato.dao.impl;

import com.xworkz.zomato.constants.JDBCconnect;
import com.xworkz.zomato.dao.ZomatoDao;
import com.xworkz.zomato.dto.ZomatoDto;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Data
@Component
public class ZomatoDaoImpl implements ZomatoDao {

    @SneakyThrows
    @Override
    public boolean save(ZomatoDto zomatoDto) {
        boolean isValid=false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        String insert="insert into zomato(name,ownername,ownerage,phoneno,branch,address,pincode,city,state,country) values (?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, zomatoDto.getName());
            preparedStatement.setString(2, zomatoDto.getOwnerName());
            preparedStatement.setInt(3,zomatoDto.getOwnerAge());
            preparedStatement.setLong(4,zomatoDto.getPhoneNo());
            preparedStatement.setString(5, zomatoDto.getBranch());
            preparedStatement.setString(6, zomatoDto.getAddress());
            preparedStatement.setLong(7,zomatoDto.getPincode());
            preparedStatement.setString(8, zomatoDto.getCity());
            preparedStatement.setString(9, zomatoDto.getState());
            preparedStatement.setString(10, zomatoDto.getCountry());

            int row= preparedStatement.executeUpdate();
            if (row >0 ){
                isValid=true;
                System.out.println(row+" "+"Roes Affected");
                System.out.println(zomatoDto);
            }else {
                System.out.println("Update error..");
            }

            return isValid;
        }
    }
}
