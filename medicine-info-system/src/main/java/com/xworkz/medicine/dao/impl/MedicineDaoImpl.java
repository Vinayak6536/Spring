package com.xworkz.medicine.dao.impl;

import com.xworkz.medicine.constants.JDBCconnect;
import com.xworkz.medicine.dao.MedicineDao;
import com.xworkz.medicine.dto.MedicineDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicineDaoImpl implements MedicineDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public boolean save(MedicineDto medicineDto) {
        boolean isValid = false;
        String insert = "insert into medicine(medicineName,medicinePrice,mg,combination,expiryDate) values (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, medicineDto.getMedicineName());
            preparedStatement.setString(2, medicineDto.getMedicinePrice());
            preparedStatement.setString(3, medicineDto.getMg());
            preparedStatement.setString(4, medicineDto.getCombination());
            preparedStatement.setString(5, medicineDto.getExpiryDate());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println(row + " " + "Rows Affected");
                isValid = true;
            } else {
                System.out.println("No Rows Affected");
            }
        }
        return isValid;
    }

    @SneakyThrows
    @Override
    public Optional<MedicineDto> getName(String medicineName) {


        String insert = "select * from medicine where medicinename=?";

        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setString(1, medicineName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("medicinename");
                String price = resultSet.getString("medicineprice");
                String mg = resultSet.getString("mg");
                String combination = resultSet.getString("combination");
                String expirydate = resultSet.getString("expirydate");

                MedicineDto medicineDto = new MedicineDto(id, name, price, mg, combination, expirydate);


                return Optional.of(medicineDto);
            }


            return Optional.empty();
        }
    }

    @SneakyThrows
    @Override
    public Optional<MedicineDto> getMedicineList(int medicineId) {

        String edit = "select * from medicine where id=?";
        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(edit)) {
            System.out.println(connection);

            preparedStatement.setString(1, String.valueOf(medicineId));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println(id);
                String name = resultSet.getString("medicinename");
                String price = resultSet.getString("medicineprice");
                String mg = resultSet.getString("mg");
                String combination = resultSet.getString("combination");
                String expirydate = resultSet.getString("expirydate");

                MedicineDto medicineDto = new MedicineDto(id, name, price, mg, combination, expirydate);


                return Optional.of(medicineDto);
            }

        }
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public boolean update(MedicineDto medicineDto) {
        boolean isValid = false;
        String update = "update medicine set medicineName=?,medicinePrice=?,mg=?,combination=?,expiryDate=? where id=?";

        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            System.out.println(connection);

            preparedStatement.setString(1, medicineDto.getMedicineName());
            preparedStatement.setString(2, medicineDto.getMedicinePrice());
            preparedStatement.setString(3, medicineDto.getMg());
            preparedStatement.setString(4, medicineDto.getCombination());
            preparedStatement.setString(5, medicineDto.getExpiryDate());
            preparedStatement.setInt(6,medicineDto.getMedicineId());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println(row + " " + "Rows Affected");
                isValid = true;
            } else {
                System.out.println("No Rows Affected");
            }
        }
        return isValid;
    }
}
