package com.miu.edu.infastructure.repositories;

import com.miu.edu.domain.aggregates.assignmentAggregate.Assignment;
import com.miu.edu.domain.aggregates.assignmentAggregate.AssignmentRepository;
import com.miu.edu.infastructure.entities.AssignmentEntity;
import com.miu.edu.infastructure.utilities.EntityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AssignmentRepositoryImpl implements AssignmentRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public AssignmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void add(Assignment assignment) {
        AssignmentEntity assignmentEntity = EntityMapper.toEntity(assignment,AssignmentEntity.class);
        entityManager.persist(assignmentEntity);
    }

    @Override
    public void update(Assignment assignment) {
        entityManager.merge(assignment);
    }

    @Override
    public Assignment findById(int id) {
        var assignmentEntity = entityManager.find(AssignmentEntity.class, id);
        return EntityMapper.toDomain(assignmentEntity,Assignment.class);
    }
}

