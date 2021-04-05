package com.example.demo.entity;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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
        String sql = "FROM Customer ORDER BY lastName";
        return entityManager
                .createQuery(sql, Customer.class)
                .getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = new Customer();
        String sql = "FROM Customer WHERE id = :customerId";
        customer = entityManager
                .createQuery(sql, Customer.class)
                .setParameter("customerId", customerId)
                .getSingleResult();
        entityManager
                .remove(entityManager.merge(customer));
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        List<Customer> customers;

        if (searchName != null && searchName.trim().length() > 0){
            String sql = "FROM Customer WHERE lower(firstName) LIKE :theName OR lower(lastName) LIKE :theName";
            customers = entityManager
                    .createQuery(sql, Customer.class)
                    .setParameter("theName", "%" + searchName.toLowerCase() + "%").getResultList();
        }else {
            String sql = "FROM Customer";
            customers = entityManager.createQuery(sql, Customer.class).getResultList();
        }



        return customers;
    }
}
