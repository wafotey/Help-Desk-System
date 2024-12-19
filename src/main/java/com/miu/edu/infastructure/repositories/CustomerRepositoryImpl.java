package com.miu.edu.infastructure.repositories;

import com.miu.edu.domain.aggregates.customerAggregate.Customer;
import com.miu.edu.domain.aggregates.customerAggregate.CustomerRepository;
import com.miu.edu.infastructure.entities.CustomerEntity;
import com.miu.edu.infastructure.utilities.EntityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void add(Customer customer) {
        CustomerEntity customerEntity = EntityMapper.toEntity(customer,CustomerEntity.class);
        entityManager.persist(customerEntity);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer findById(int id) {
        var customerEntity = entityManager.find(CustomerEntity.class, id);
        return EntityMapper.toDomain(customerEntity,Customer.class);
    }
}
