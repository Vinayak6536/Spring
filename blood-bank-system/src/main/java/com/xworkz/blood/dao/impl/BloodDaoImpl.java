package com.xworkz.blood.dao.impl;

import com.xworkz.blood.constants.JDBCconnect;
import com.xworkz.blood.dao.BloodDao;
import com.xworkz.blood.dto.BloodDto;
import com.xworkz.blood.service.BloodService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BloodDaoImpl implements BloodDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public boolean save(BloodDto dto) {

        String insert = "INSERT INTO donor_registration " +
                "(donor_id, first_name, last_name, dob, zip_code, email, phone, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, dto.getDonorId());
            preparedStatement.setString(2, dto.getFirstName());
            preparedStatement.setString(3, dto.getLastName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(dto.getDob())); // yyyy-mm-dd
            preparedStatement.setInt(5, dto.getZipCode());
            preparedStatement.setString(6, dto.getEmail());
            preparedStatement.setLong(7, dto.getPhone());
            preparedStatement.setString(8, dto.getPassword()); // store hashed password

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Inserted: " + rows);
        }

        return true;
    }

    @SneakyThrows
    @Override
    public List<BloodDto> findByFirstName(String firstName) {
        List<BloodDto> list = new ArrayList<>();

        String query =
                "SELECT donor_id, first_name, last_name, dob, zip_code, email, phone " +
                        "FROM donor_registration WHERE first_name = ?";

        try (Connection connection = DriverManager.getConnection(
                JDBCconnect.URL.getValue(),
                JDBCconnect.USERNAME.getValue(),
                JDBCconnect.PASSWORD.getValue());

             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, firstName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BloodDto dto = new BloodDto();
                dto.setDonorId(resultSet.getString("donor_id"));
                dto.setFirstName(resultSet.getString("first_name"));
                dto.setLastName(resultSet.getString("last_name"));
                dto.setDob(resultSet.getDate("dob").toString());
                dto.setZipCode(resultSet.getInt("zip_code"));
                dto.setEmail(resultSet.getString("email"));
                dto.setPhone(resultSet.getLong("phone"));

                list.add(dto);

                return list;
            }


            return Collections.emptyList();
        }
    }

    @SneakyThrows
    @Override
    public boolean updatedSave(BloodDto dto) {
        String insert = "update donor_registration set donor_id=?,first_name= ?,last_name= ?, dob=?,zip_code= ?,email= ?, phone=? where first_name=?";


        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, dto.getDonorId());
            preparedStatement.setString(2, dto.getFirstName());
            preparedStatement.setString(3, dto.getLastName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(dto.getDob())); // yyyy-mm-dd
            preparedStatement.setInt(5, dto.getZipCode());
            preparedStatement.setString(6, dto.getEmail());
            preparedStatement.setLong(7, dto.getPhone());
            preparedStatement.setString(8, dto.getFirstName());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Inserted: " + rows);
        }

        return true;
    }

    @SneakyThrows
    @Override
    public boolean deleted(String firstName) {
        boolean isValid=false;
        String query =
                "delete from donor_registration where first_name=?";

        try (Connection connection = DriverManager.getConnection(
                JDBCconnect.URL.getValue(),
                JDBCconnect.USERNAME.getValue(),
                JDBCconnect.PASSWORD.getValue());

             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, firstName);

            int delete = preparedStatement.executeUpdate();

            if (delete == 1) {
                System.out.println("Row Deleted");
                isValid=true;
            }
        }
        return isValid;
    }
}

