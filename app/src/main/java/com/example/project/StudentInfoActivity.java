package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentInfoActivity  extends AppCompatActivity{
    EditText studentName, studentUsn,collegeName,studentSem,studentDept;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_info);

        BindUiElement();

        nextBtn.setOnClickListener(view -> {
            Intent intent = new Intent(StudentInfoActivity.this, ProjectInfoActivity.class);
            startActivity(intent);
        });
    }

    private void BindUiElement() {
        studentName = (EditText) findViewById(R.id.edit_name);
        studentDept = (EditText) findViewById(R.id.edit_department);
        studentSem = (EditText) findViewById(R.id.edit_semester);
        studentUsn = (EditText) findViewById(R.id.edit_usn);
        collegeName = (EditText) findViewById(R.id.edit_college);

        nextBtn = (Button) findViewById(R.id.btn_next);
    }

}