package com.example.youTask.repository.impl;

import com.example.youTask.bean.User;
import com.example.youTask.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        this.emf = Persistence.createEntityManagerFactory("devdync");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public User save(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            User user = entityManager.find(User.class, id);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User update(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User updatedUser = entityManager.merge(user);
            transaction.commit();
            return updatedUser;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void delete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<User> findByName(String name) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = :name OR u.lastName = :name", User.class)
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
