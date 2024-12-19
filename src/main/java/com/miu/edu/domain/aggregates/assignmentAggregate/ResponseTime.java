package com.miu.edu.domain.aggregates.assignmentAggregate;

import com.miu.edu.domain.shared.ValueObject;
import java.time.Duration;
import java.time.LocalDateTime;

public class ResponseTime extends ValueObject {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    // Getters for the fields
    public LocalDateTime getStartLimit() {
        return startDateTime;
    }

    public LocalDateTime getEndLimit() {
        return endDateTime;
    }

    // Method to calculate the duration between startLimit and endLimit
    public Duration getDuration() {
        return Duration.between(startDateTime, endDateTime);
    }

    @Override
    protected boolean equalsCore(ValueObject other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ResponseTime responseTime = (ResponseTime) other;
        return startDateTime.equals(responseTime.startDateTime) && endDateTime.equals(responseTime.endDateTime);
    }

    @Override
    public String toString() {
        return "Duration{" +
                "startLimit=" + startDateTime +
                ", endLimit=" + endDateTime +
                ", duration=" + getDuration().toHours() + " hours" +
                '}';
    }

    @Override
    protected String fieldValues() {
        return "";
    }
}