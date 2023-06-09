package thiago.com.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import thiago.com.agenda.model.Student;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    public void save(Student student) {
        students.add(student);
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }
}
