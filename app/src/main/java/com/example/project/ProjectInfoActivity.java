package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectInfoActivity  extends AppCompatActivity{
    EditText projectName, projectDesc,projectLink;
    Button nextBtn;
    private DatabaseHelper databaseHelper;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);
        databaseHelper = new DatabaseHelper(ProjectInfoActivity.this);
        BindUiElement();
         preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProject();
                Intent intent = new Intent(ProjectInfoActivity.this, ResearchInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BindUiElement() {
        projectName =  findViewById(R.id.edit_project_name);
        projectDesc =  findViewById(R.id.edit_project_description);
        projectLink =  findViewById(R.id.edit_project_link);

        nextBtn =  findViewById(R.id.btn_next);
    }

    private void addProject() {
        String name = projectName.getText().toString();
        String description = projectDesc.getText().toString();
        String link = projectLink.getText().toString();

        long rowId;
        long studentId = StudentInfoActivity.getCurrentStudentId(preferences);
        try {
            rowId = databaseHelper.addProject(name, link, description, studentId);
            if (rowId != -1L) {
                // Insertion successful
                Toast.makeText(ProjectInfoActivity.this, "Project Added", Toast.LENGTH_SHORT).show();
            } else {
                // Insertion failed
                Toast.makeText(ProjectInfoActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            Toast.makeText(ProjectInfoActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
        }

    }

}