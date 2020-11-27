package com.project.repository.impl;

import com.project.entity.Customer;
import com.project.repository.CustomerRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select s from customer s", Customer.class);
           return typedQuery.getResultList();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public void update(Customer customer) {
        Query<Customer> query =BaseRepository.sessionFactory.createQuery("select s from customer s", Customer.class);
        int result = query.executeUpdate();
    }
}
