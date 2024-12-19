package com.miu.edu.domain.aggregates.assignmentAggregate;

import com.miu.edu.domain.aggregates.customerAggregate.Customer;

public interface AssignmentRepository {
    void add(Assignment assignment);
    void update(Assignment assignment);
    Assignment findById(int id);
}
