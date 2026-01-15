package com.xworkz.job.dao.impl;

import com.xworkz.job.constants.JDBCconnect;
import com.xworkz.job.dao.JobDao;
import com.xworkz.job.dto.EducationDto;
import com.xworkz.job.dto.PersonalDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;


@Repository
public class JobDaoImpl implements JobDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection = DriverManager.getConnection(JDBCconnect.URL.getValue(), JDBCconnect.USERNAME.getValue(), JDBCconnect.PASSWORD.getValue());

    public JobDaoImpl() throws SQLException {
    }


    @SneakyThrows
    @Override
    public boolean personalDataSave(PersonalDto personalDto) {

        String insert="insert into personal_details(firstname,lastname,dob,age,email,phone) values (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement= connection.prepareStatement(insert)){
            System.out.println(connection);
            preparedStatement.setString(1, personalDto.getFirstName());
            preparedStatement.setString(2, personalDto.getLastName());
            preparedStatement.setString(3, personalDto.getDob());
            preparedStatement.setInt(4,personalDto.getAge());
            preparedStatement.setString(5, personalDto.getEmail());
            preparedStatement.setLong(6,personalDto.getPhone());

            int row= preparedStatement.executeUpdate();
            if (row == 1){
                System.out.println(row+" "+"Rows Affected");
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    @Override
    public Optional<PersonalDto> getIdByName(int id) {
        System.out.println("Name Dao Method started...");
        String insert="select id from personal_details where id=?";
        try (PreparedStatement preparedStatement= connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setInt(1, id);
            System.out.println(id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id1= resultSet.getInt("id");
                System.out.println(id1);
                //String name1= resultSet.getString("");
                //System.out.println(name1);
                PersonalDto personalDto=new PersonalDto(id1);
                return Optional.of(personalDto);
            }else {
                System.out.println("No record");
                return Optional.empty();
            }

        }
    }

    @SneakyThrows
    @Override
    public Optional<PersonalDto> getIdByPhone(long phone) {
        System.out.println("Name Dao Method started...");
        String insert = "select id from personal_details where phone=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println(connection);

            preparedStatement.setLong(1, phone);
            System.out.println(phone);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                System.out.println(id1);
                //String name1= resultSet.getString("");
                //System.out.println(name1);
                PersonalDto personalDto = new PersonalDto(id1);
                return Optional.of(personalDto);
            } else {
                System.out.println("No record");

                return Optional.empty();
            }
        }
    }

    @SneakyThrows
    @Override
    public boolean educationDataSave(EducationDto educationDto) {
        String insert="insert into education_details(school_Name,school_Perc,college_Name,college_Perc,degree_Name,degree_Perc,master_Name,master_Perc) values (?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement= connection.prepareStatement(insert)) {
            System.out.println(connection);
            preparedStatement.setString(1, educationDto.getSchoolName());
            preparedStatement.setDouble(2,educationDto.getSchoolPerc());
            preparedStatement.setString(3, educationDto.getCollegeName());
            preparedStatement.setDouble(4,educationDto.getCollegePerc());
            preparedStatement.setString(5, educationDto.getDegreeName());
            preparedStatement.setDouble(6,educationDto.getDegreePerc());
            preparedStatement.setString(7, educationDto.getMasterName());
            preparedStatement.setDouble(8,educationDto.getMasterPerc());

            int row= preparedStatement.executeUpdate();
            if (row == 1){
                System.out.println(row+" "+"Rows Affected");
                return true;
            }
        } return false;
    }

//    @Override
//    public boolean experienceDataSave(ExperienceDto experienceDto) {
//        String insert="insert into education_details(school_Name,school_Perc,college_Name,college_Perc,degree_Name,degree_Perc,master_Name,master_Perc) values (?,?,?,?,?,?,?,?)";
//        try (PreparedStatement preparedStatement= connection.prepareStatement(insert)) {
//            System.out.println(connection);
//
//
//
//        }
//        return false;
//    }
}
