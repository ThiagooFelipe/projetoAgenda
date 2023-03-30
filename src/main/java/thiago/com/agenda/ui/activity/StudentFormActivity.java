package thiago.com.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import thiago.com.agenda.R;
import thiago.com.agenda.dao.StudentDAO;
import thiago.com.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Novo Aluno";
    private EditText fieldName;
    private EditText fieldContact;
    private EditText fieldEmail;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(TITLE_APPBAR);
        initializationFields();
        configureSaveButton();
    }

    private void configureSaveButton() {
        Button saveButton = findViewById(R.id.activity_student_form_button_save);
        saveButton.setOnClickListener(view -> {
            Student createdStudent = createStudent();
            save(createdStudent);
        });
    }

    private void initializationFields() {
        fieldName = findViewById(R.id.activity_student_form_name);
        fieldContact = findViewById(R.id.activity_student_form_contact);
        fieldEmail = findViewById(R.id.activity_student_form_email);
    }

    private void save(Student student) {
        dao.save(student);
        finish();
    }

    @NonNull
    private Student createStudent() {
        String name = fieldName.getText().toString();
        String contact = fieldContact.getText().toString();
        String email = fieldEmail.getText().toString();

        Student createStudent = new Student(name, contact, email);
        return createStudent;
    }
}