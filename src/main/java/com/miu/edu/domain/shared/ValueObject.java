package com.miu.edu.domain.shared;

import java.util.Objects;

public abstract class ValueObject {

    // Overridden equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        ValueObject other = (ValueObject) obj;
        return equalsCore(other); // Compare based on values (implemented by subclasses)
    }

    // Abstract method to compare field-by-field (implemented by subclasses)
    protected abstract boolean equalsCore(ValueObject other);

    // Overridden hashCode method
    @Override
    public int hashCode() {
        return Objects.hashCode(this); // Use Objects.hash to generate a consistent hash code
    }

    // Helper method to compare fields safely
    protected static boolean objectEquals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2); // Safely compare objects (null-aware)
    }

    // Optional: Provide a meaningful string representation of the value object
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + fieldValues() + "}";
    }

    // Abstract method for returning a string representation of the fields (for toString)
    protected abstract String fieldValues();
}
