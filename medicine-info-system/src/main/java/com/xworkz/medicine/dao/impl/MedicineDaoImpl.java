package com.xworkz.medicine.dao.impl;

import com.xworkz.medicine.constants.JDBCconnect;
import com.xworkz.medicine.dao.MedicineDao;
import com.xworkz.medicine.dto.MedicineDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
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
        boolean isValid=false;
        String insert="insert into medicine(medicineName,medicinePrice,mg,combination,expiryDate) values (?,?,?,?,?)";

        try (Connection connection= DriverManager.getConnection(JDBCconnect.URL.getValue(),JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement= connection.prepareStatement(insert)){
            System.out.println(connection);

            preparedStatement.setString(1, medicineDto.getMedicineName());
            preparedStatement.setString(2, medicineDto.getMedicinePrice());
            preparedStatement.setString(3, medicineDto.getMg());
            preparedStatement.setString(4, medicineDto.getCombination());
            preparedStatement.setString(5, medicineDto.getExpiryDate());

            int row=preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println(row+" "+"Rows Affected");
                isValid=true;
            }else {
                System.out.println("No Rows Affected");
            }
        }
        return isValid;
    }
}
