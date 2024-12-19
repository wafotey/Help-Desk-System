package com.miu.edu.infastructure.entities;

import jakarta.persistence.*;

@Entity(name = "Message")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MessageEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    protected String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
