package com.xworkz.module.repository.admin.batch.impl;

import com.xworkz.module.entity.BatchEntity;
import com.xworkz.module.entity.StudentEntity;
import com.xworkz.module.repository.admin.batch.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class BatchRepositoryImpl implements BatchRepository {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(BatchEntity batchEntity) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(batchEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public List<BatchEntity> getBatchList() {
        List fromBatchEntity = factory.createEntityManager().createQuery("from BatchEntity").getResultList();
        System.out.println(fromBatchEntity);
        return fromBatchEntity;
    }

    @Override
    public Optional<BatchEntity> getBatchDetails(int batchId) {
       BatchEntity batchEntity= factory.createEntityManager().find(BatchEntity.class,batchId);
     //   System.out.println(batchEntity);
       return Optional.of(batchEntity);
    }

    @Override
    public Optional<BatchEntity> getBatchId(int batchId) {
        try {
            BatchEntity batchEntity=factory.createEntityManager().find(BatchEntity.class,batchId);
            return Optional.of(batchEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
