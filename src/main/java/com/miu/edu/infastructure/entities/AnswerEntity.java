package com.miu.edu.infastructure.entities;

import jakarta.persistence.*;

@Entity(name = "Answer")
public class AnswerEntity extends MessageEntity {

    @Column(nullable = false)
    private int userId;

    @Column(name = "question_id", nullable = false)  // Ensuring that the field is not null
    private int questionId;

    // Use @ManyToOne to reference the associated Question entity.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id", insertable = false, updatable = false)
    private QuestionEntity question;

    // Default constructor
    protected AnswerEntity() {}

    // Constructor
    public AnswerEntity(int userId, int questionId, String answer) {
        this.userId = userId;
        this.questionId = questionId;
        this.description = answer;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
