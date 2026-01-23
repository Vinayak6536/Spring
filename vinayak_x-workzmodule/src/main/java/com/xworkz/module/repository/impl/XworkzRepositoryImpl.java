package com.xworkz.module.repository.impl;

import com.xworkz.module.entity.XworkzEntity;
import com.xworkz.module.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.time.LocalDateTime;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean checkEmailOrPhone(String emailorPhone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            if (emailorPhone.matches("\\d+")) {
                long phone = Long.parseLong(emailorPhone);
                Query query = entityManager.createQuery("select 1 from XworkzEntity e where e.phoneNo=:phone").setParameter("phone", phone);
                int exist = (int) query.getSingleResult();
                if (exist > 0) return true;
            } else {
                Query query = entityManager.createQuery("select 1 from XworkzEntity e where e.email=:email").setParameter("email", emailorPhone);
                int exist = (int) query.getSingleResult();
                if (exist > 0) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        System.out.println("rep"+xworkzEntity.getPhoneNo());
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
    public String findEmail(String emailOrPhone) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            if (emailOrPhone.matches("\\d+")) {
                long phone = Long.parseLong(emailOrPhone);
                Query query = entityManager.createQuery("select e.password from XworkzEntity e where e.phoneNo=:phone").setParameter("phone", phone);
                return (String) query.getSingleResult();
            } else {
                Query query = entityManager.createQuery("select e.password from XworkzEntity e where e.email=:email").setParameter("email", emailOrPhone);
                return (String) query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public int getCount(String emailOrPhoneNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (emailOrPhoneNo.matches("\\d+")) {
            long phone = Long.parseLong(emailOrPhoneNo);
            Query query = entityManager.createQuery("select e.count from XworkzEntity e where e.phoneNo=:phone").setParameter("phone", phone);
            return (int) query.getSingleResult();
        } else {
            Query query = entityManager.createQuery("select e.count from XworkzEntity e where e.email=:email").setParameter("email", emailOrPhoneNo);
            return (int) query.getSingleResult();
        }
    }

    @Override
    public void updateCount(String emailOrPhone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (emailOrPhone.matches("\\d+")) {
            long phone = Long.parseLong(emailOrPhone);
            entityManager.getTransaction().begin();
            entityManager.createQuery("update XworkzEntity e set e.count=e.count+1 where e.phoneNo=:phone").setParameter("phone", phone).executeUpdate();
            entityManager.getTransaction().commit();

        } else {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update XworkzEntity e set e.count=e.count+1 where e.email=:email").setParameter("email", emailOrPhone).executeUpdate();
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void setCount(String emailOrPhone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (emailOrPhone.matches("\\d+")) {
            long phone = Long.parseLong(emailOrPhone);
            entityManager.getTransaction().begin();
            entityManager.createQuery("update XworkzEntity e set e.count=0 where e.phoneNo=:phone").setParameter("phone", phone).executeUpdate();
            entityManager.getTransaction().commit();

        } else {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update XworkzEntity e set e.count=0 where e.email=:email").setParameter("email", emailOrPhone).executeUpdate();
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public boolean saveOtp(String emailOrPhone, int randaomOTP) {
        boolean isOtpValid = false;
        System.out.println(emailOrPhone);
        System.out.println(randaomOTP);
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("update XworkzEntity e set e.otp=:otp, e.otpCreatedTime=:otptime where e.email=:email").setParameter("otp", randaomOTP).setParameter("otptime",LocalDateTime.now()).setParameter("email", emailOrPhone);
            int otp = query.executeUpdate();
            if (otp > 0) {
                isOtpValid = true;
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOtpValid;
    }

    @Override
    public void clearExpiredOtp() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("update XworkzEntity e set e.otp=null,e.otpCreatedTime=null where e.otpCreatedTime < :expirytime").setParameter("expirytime", LocalDateTime.now().minusMinutes(5)).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int verifyOtp(String emailOrPhone) {
        try {
            System.out.println(emailOrPhone+"repo");
            return (int) entityManagerFactory.createEntityManager().createQuery("select e.otp from XworkzEntity e where e.email=:email").setParameter("email", emailOrPhone).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean resetPassword(String emailOrPhone,String encrypt) {
        try {
            EntityManager entityManager= entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            int update = entityManager.createQuery("update XworkzEntity e set e.password=:password where e.email=:email").setParameter("password", encrypt).setParameter("email", emailOrPhone).executeUpdate();
            entityManager.getTransaction().commit();
            if (update > 0){
                System.out.println("Updated Successfully");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
