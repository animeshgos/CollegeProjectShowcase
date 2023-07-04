package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentInfoActivity  extends AppCompatActivity{
    EditText studentName, studentUsn,collegeName,studentSem,studentDept;
    Button nextBtn;

    private DatabaseHelper databaseHelper;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_info);
        databaseHelper = new DatabaseHelper(StudentInfoActivity.this);
        preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);

        BindUiElement();

        nextBtn.setOnClickListener(view -> {
            addStudent();
            Intent intent = new Intent(StudentInfoActivity.this, ProjectInfoActivity.class);
            startActivity(intent);
        });
    }

    private void BindUiElement() {
        studentName =  findViewById(R.id.edit_name);
        studentDept =  findViewById(R.id.edit_department);
        studentSem =  findViewById(R.id.edit_semester);
        studentUsn =  findViewById(R.id.edit_usn);
        collegeName =  findViewById(R.id.edit_college);

        nextBtn =  findViewById(R.id.btn_next);
    }

    private void addStudent() {
        String name = studentName.getText().toString();
        String department = studentDept.getText().toString();
        int semester = Integer.parseInt(studentSem.getText().toString());
        String usn = studentUsn.getText().toString();
        String college = collegeName.getText().toString();

        long rowId;
        try {
            rowId = databaseHelper.addStudent(name, college, usn, department,semester);
            if (rowId != -1L) {
                // Insertion successful
                setCurrentStudentId(rowId);
                Toast.makeText(StudentInfoActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
            } else {
                // Insertion failed
                Toast.makeText(StudentInfoActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            Toast.makeText(StudentInfoActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
        }

    }
    public void setCurrentStudentId(long studentId) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("currentStudentId", studentId);
        editor.apply();
    }

    public static long getCurrentStudentId( SharedPreferences preferences) {
        Log.d("Shared preference in student", "preference"+preferences);
        long currentStudentId = preferences.getLong("currentStudentId", -1);
        Log.d("SharedPreferences", "currentStudentId: " + currentStudentId);
        return currentStudentId;

    }


}