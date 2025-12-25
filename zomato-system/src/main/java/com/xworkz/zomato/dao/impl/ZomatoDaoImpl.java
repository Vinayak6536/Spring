package com.xworkz.zomato.dao.impl;

import com.xworkz.zomato.constants.JDBCconnect;
import com.xworkz.zomato.dao.ZomatoDao;
import com.xworkz.zomato.dto.ZomatoDto;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Data
@Repository
public class ZomatoDaoImpl implements ZomatoDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    @Override
    public boolean save(ZomatoDto zomatoDto) {
        boolean isValid = false;


        String insert = "insert into zomato(name,ownername,ownerage,phoneno,branch,address,pincode,city,state,country) values (?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, zomatoDto.getName());
            preparedStatement.setString(2, zomatoDto.getOwnerName());
            preparedStatement.setInt(3, zomatoDto.getOwnerAge());
            preparedStatement.setLong(4, zomatoDto.getPhoneNo());
            preparedStatement.setString(5, zomatoDto.getBranch());
            preparedStatement.setString(6, zomatoDto.getAddress());
            preparedStatement.setLong(7, zomatoDto.getPincode());
            preparedStatement.setString(8, zomatoDto.getCity());
            preparedStatement.setString(9, zomatoDto.getState());
            preparedStatement.setString(10, zomatoDto.getCountry());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                isValid = true;
                System.out.println(row + " " + "Rows Affected");
                System.out.println(zomatoDto);
            } else {
                System.out.println("Update error..");
            }

            return isValid;
        }
    }

    @SneakyThrows
    @Override
    public Optional<ZomatoDto> savePhone(Long phoneNo) {

        String sql = ("select * from zomato where phoneno=?");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println(connection);

            preparedStatement.setLong(1, phoneNo);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String ownerName = resultSet.getString(3);
                int ownerAge = resultSet.getInt(4);
                long phoneNo1 = resultSet.getLong(5);
                String branch = resultSet.getString(6);
                String address = resultSet.getString(7);
                long pincode = resultSet.getLong(8);
                String city = resultSet.getString(9);
                String state = resultSet.getString(10);
                String country = resultSet.getString(11);

                ZomatoDto zomatoDto1 = new ZomatoDto(name, ownerName, ownerAge, phoneNo1, branch, address, pincode, city, state, country);
                System.out.println(zomatoDto1);
                return Optional.of(zomatoDto1);
            }
        }


        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public Optional<ZomatoDto> saveName(String name) {
        String sql = ("select * from zomato where name=?");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println(connection);

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                String name1 = resultSet.getString(2);
                String ownerName = resultSet.getString(3);
                int ownerAge = resultSet.getInt(4);
                long phoneNo1 = resultSet.getLong(5);
                String branch = resultSet.getString(6);
                String address = resultSet.getString(7);
                long pincode = resultSet.getLong(8);
                String city = resultSet.getString(9);
                String state = resultSet.getString(10);
                String country = resultSet.getString(11);

                ZomatoDto zomatoDto1 = new ZomatoDto(name1, ownerName, ownerAge, phoneNo1, branch, address, pincode, city, state, country);
                System.out.println(zomatoDto1);
                return Optional.of(zomatoDto1);
            }
        }
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public boolean updated(ZomatoDto zomatoDto) {
        boolean isValid = false;
        String update = "update zomato set name=?,ownername=?,ownerage=?,phoneno=?,branch=?,address=?,pincode=?,city=?,state=?,country=? where name=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            System.out.println(connection);

            preparedStatement.setString(1, zomatoDto.getName());
            preparedStatement.setString(2, zomatoDto.getOwnerName());
            preparedStatement.setInt(3, zomatoDto.getOwnerAge());
            preparedStatement.setLong(4, zomatoDto.getPhoneNo());
            preparedStatement.setString(5, zomatoDto.getBranch());
            preparedStatement.setString(6, zomatoDto.getAddress());
            preparedStatement.setLong(7, zomatoDto.getPincode());
            preparedStatement.setString(8, zomatoDto.getCity());
            preparedStatement.setString(9, zomatoDto.getState());
            preparedStatement.setString(10, zomatoDto.getCountry());
            preparedStatement.setString(11, zomatoDto.getName());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                isValid = true;

            } else {
                System.out.println("Update error..");
            }

            return isValid;
        }


    }
}
