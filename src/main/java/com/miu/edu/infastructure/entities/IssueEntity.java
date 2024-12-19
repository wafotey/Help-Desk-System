package com.miu.edu.infastructure.entities;

import jakarta.persistence.*;

@Entity(name = "Issue")
public class IssueEntity  extends MessageEntity{

    protected IssueEntity() {}

    public IssueEntity(String description) {
        this.description = description;
    }
}
