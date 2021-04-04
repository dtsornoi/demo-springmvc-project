package com.example.demo.persistance;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getCustomers() {
        String sql = "FROM Customer";
        return entityManager
                .createQuery(sql, Customer.class)
                .getResultList();
    }
}
