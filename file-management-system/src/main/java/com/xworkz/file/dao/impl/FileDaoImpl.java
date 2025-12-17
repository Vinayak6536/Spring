package com.xworkz.file.dao.impl;

import com.xworkz.file.constant.JDBCconnect;
import com.xworkz.file.dao.FileDao;
import com.xworkz.file.dto.FileDto;
import com.xworkz.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class FileDaoImpl implements FileDao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(FileDto fileDto) {
        boolean saved = false;
        String insert = "insert into filemanage(id,filename,filetype,filesize) values (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setInt(1, fileDto.getId());
            preparedStatement.setString(2, fileDto.getFileName());
            preparedStatement.setString(3, fileDto.getFileType());
            preparedStatement.setString(4, fileDto.getFileSize());

            int row = preparedStatement.executeUpdate();
            System.out.println(row + "Rows Affected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return saved;
    }
}
