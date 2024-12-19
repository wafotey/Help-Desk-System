package com.miu.edu.infastructure.utilities;

import org.modelmapper.ModelMapper;

public class EntityMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Convert domain object to entity
    public static <D, E> E toEntity(D domainObject, Class<E> entityClass) {
        return modelMapper.map(domainObject, entityClass);
    }

    // Convert entity to domain object
    public static <E, D> D toDomain(E entity, Class<D> domainClass) {
        return modelMapper.map(entity, domainClass);
    }

}
