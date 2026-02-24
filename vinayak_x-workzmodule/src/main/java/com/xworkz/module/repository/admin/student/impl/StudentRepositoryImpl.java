package com.xworkz.module.repository.admin.student.impl;

import com.xworkz.module.entity.StudentEntity;
import com.xworkz.module.repository.admin.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean saveStudents(StudentEntity studentEntity) {
        try {
            EntityManager entityManager = factory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(studentEntity);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<StudentEntity> getStudentsList() {
        try {
            return factory.createEntityManager().createQuery("SELECT s FROM StudentEntity s", StudentEntity.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();

        }

    }

    @Override
    public List<StudentEntity> getStudentsByBatchId(int batchId) {
        try {
            return factory.createEntityManager().createQuery("select e from StudentEntity e where e.batch.batchId=:batchId",StudentEntity.class).setParameter("batchId", batchId).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<StudentEntity> editStudentDetails(int studentId) {
    //    System.out.println("Student Repo"+studentId);
        try {
            StudentEntity studentEntity = factory.createEntityManager().find(StudentEntity.class, studentId);
    //        System.out.println(studentEntity);
            return Optional.ofNullable(studentEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean updateStudentDetails(StudentEntity studentEntity) {
        try {
            EntityManager entityManager= factory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query= entityManager.createQuery("update StudentEntity e set e.studentName=:studentName,e.phone=:phone," +
                    "e.age=:age,e.gender=:gender,e.qualification=:qualification,e.collegeName=:collegeName," +
                    "e.address=:address,e.joinedDate=:joinedDate where e.batchId=:batchId");
            query.setParameter("studentName",studentEntity.getStudentName());
            query.setParameter("phone",studentEntity.getPhone());
            query.setParameter("age",studentEntity.getAge());
            query.setParameter("gender",studentEntity.getGender());
            query.setParameter("qualification",studentEntity.getQualification());
            query.setParameter("collegeName",studentEntity.getCollegeName());
            query.setParameter("address",studentEntity.getAddress());
            query.setParameter("joinedDate",studentEntity.getJoinedDate());
            query.setParameter("batchId",studentEntity.getBatchId());
            int updatedDetails=query.executeUpdate();

            Query query1= entityManager.createQuery("Update ImageEntity i set i.originalName=:name,i.imagePath=:path,i.fileSize=:fileSize,i.contentType=:type where i.student=:student");
            query1.setParameter("name",studentEntity.getStudentImage().getOriginalName());
            query1.setParameter("path",studentEntity.getStudentImage().getImagePath());

            
            if (updatedDetails > 0){
                System.out.println("Student Details Updated");
                return true;
            }



//            EntityManager entityManager = factory.createEntityManager();
//            entityManager.getTransaction().begin();
//
//            // ✅ Correct way
//            entityManager.merge(studentEntity);
//
//            entityManager.getTransaction().commit();
//            entityManager.close();
//
//            System.out.println("Student Details Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(int studentId) {
        try {
            EntityManager entityManager= factory.createEntityManager();
            entityManager.getTransaction().begin();
            StudentEntity student=entityManager.find(StudentEntity.class,studentId);
            if (student != null){
                student.setActive(false);
                entityManager.persist(student);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
