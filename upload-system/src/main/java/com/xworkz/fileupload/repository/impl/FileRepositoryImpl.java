package com.xworkz.fileupload.repository.impl;

import com.xworkz.fileupload.entity.FileEntity;
import com.xworkz.fileupload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class FileRepositoryImpl implements FileRepository {
    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(FileEntity fileEntity) {
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fileEntity);
        entityManager.getTransaction().commit();
        return true;
    }
}
