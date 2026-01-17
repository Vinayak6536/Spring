package com.xworkz.module.repository.impl;

import com.xworkz.module.entity.XworkzEntity;
import com.xworkz.module.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        if (xworkzEntity != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(xworkzEntity);
            entityManager.getTransaction().commit();

            return true;
        }
        return false;
    }

    @Override
    public XworkzEntity findEmail(String emailOrPhone) {
        System.out.println(emailOrPhone);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (emailOrPhone.matches("\\d+")) {
            long phone = Long.parseLong(emailOrPhone);
            Query query=entityManager.createQuery("select e from XworkzEntity e where e.phoneNo=:phone").setParameter("phone", phone);
            return (XworkzEntity) query.getSingleResult();
        }
        else {
            Query query=entityManager.createQuery("select e from XworkzEntity e where e.email=:email").setParameter("email", emailOrPhone);
            return (XworkzEntity) query.getSingleResult();
        }
    }
}
