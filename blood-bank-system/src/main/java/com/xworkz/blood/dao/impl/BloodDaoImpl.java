package com.xworkz.blood.dao.impl;

import com.xworkz.blood.dao.BloodDao;
import com.xworkz.blood.entity.BloodEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.Collections;
import java.util.List;

@Repository
public class BloodDaoImpl implements BloodDao {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(BloodEntity entity) {
        System.out.println(entity);
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return true;
    }


    @Override
    public List<BloodEntity> findByFirstName(String firstName) {
        List<BloodEntity> bloodEntity = factory.createEntityManager().createQuery("from BloodEntity e where e.firstName = :efirstName").setParameter("efirstName", firstName).getResultList();
        if (bloodEntity != null) {
            System.out.println(bloodEntity);
            return bloodEntity;
        }
        return Collections.emptyList();
    }

    @SneakyThrows
    @Override
    public boolean updatedSave(BloodEntity entity) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update BloodEntity e set e.firstName=:fn,e.lastName=:ln,e.dob=:dob,e.zipCode=:zipcode");
        query.setParameter("fn", entity.getFirstName());
        query.setParameter("ln", entity.getLastName());
        query.setParameter("dob", entity.getDob());
        query.setParameter("zipcode", entity.getZipCode());
//        query.setParameter("email",entity.getEmail());
//        query.setParameter("phone",entity.getPhone());

        int update = query.executeUpdate();
        entityManager.getTransaction().commit();
        if (update > 0) {
            System.out.println("Updated" + update + " " + "Row");
        }
        return true;
    }

    @SneakyThrows
    @Override
    public boolean deleted(String id) {
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        int delete=entityManager.createQuery("delete from BloodEntity e where e.donorId=:id").setParameter("id", id).executeUpdate();
        entityManager.getTransaction().commit();
        if (delete > 0){
            System.out.println("Deleted Successfully");
            return true;
        }
        return false;
    }
}

