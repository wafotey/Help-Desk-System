package com.miu.edu.domain.aggregates.customerAggregate;

public interface CustomerRepository {
    void add(Customer customer);
    void update(Customer customer);
    Customer findById(int id);
}

