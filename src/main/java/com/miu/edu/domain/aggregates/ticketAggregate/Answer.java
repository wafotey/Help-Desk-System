package com.miu.edu.domain.aggregates.ticketAggregate;

public class Answer extends Message {
    public int userId;
    public int questionId;

    public Answer(int userId, int questionId, String answer) {
        this.userId = userId;
        this.questionId = questionId;
        this.description = answer;
    }

    public int getUserId() {
        return userId;
    }

    public int getQuestionId() {
        return questionId;
    }
}
