package thiago.com.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import thiago.com.agenda.R;
import thiago.com.agenda.dao.StudentDAO;

public class StudentsListActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de Alunos";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        setTitle(TITLE_APPBAR);
        configureFabNewStudent();
    }

    private void configureFabNewStudent() {
        FloatingActionButton buttonNewStudent = findViewById(R.id.activity_list_students_new_student);
        buttonNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureList();
    }

    private void configureList() {
        ListView listStudents = findViewById(R.id.activity_main_list_students_listview);
        listStudents.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
