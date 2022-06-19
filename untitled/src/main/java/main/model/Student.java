package main.model;

import java.io.Serializable;
import java.util.Objects;

public record Student(Type_Student type) implements Serializable {

    public Type_Student getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return type == student.type;
    }

    @Override
    public String toString() {
        return "studente di colore " + type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
