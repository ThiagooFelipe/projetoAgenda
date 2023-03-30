package thiago.com.agenda.model;

import androidx.annotation.NonNull;

public class Student {
    private final String name;
    private final String contact;
    private final String email;

    public Student(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
