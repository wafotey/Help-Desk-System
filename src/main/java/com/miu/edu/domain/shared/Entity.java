package com.miu.edu.domain.shared;

import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

public abstract class Entity {

    // The unique identifier for the entity
    @Id
    private long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // Constructor to generate a new unique identifier for the entity
    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    // Get the unique identifier of the entity
    public long getId() {
        return id;
    }

    // Equality check: Entities are equal if they have the same ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        Entity other = (Entity) obj;
        return Objects.equals(this.id, other.id); // Compare based on the ID
    }

    // Hash code: Generate hash code based on the entity's ID
    @Override
    public int hashCode() {
        return Objects.hash(id); // Hash code based on the ID
    }

    // Optional: Provides a string representation of the entity (helpful for debugging)
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "'}";
    }

    private List<DomainEvent> domainEvents = new ArrayList<>();

    protected void addDomainEvent (DomainEvent event) {
        domainEvents.add(event);
    }


    public List<DomainEvent> getDomainEvents( ) {
        return domainEvents;
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}


