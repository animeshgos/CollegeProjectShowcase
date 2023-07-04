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

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ResearchInfoActivity  extends AppCompatActivity{
    EditText researchName, professorName,researchLink,researchDesc;
    Button nextBtn;
    private DatabaseHelper databaseHelper;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research_info);

        databaseHelper = new DatabaseHelper(ResearchInfoActivity.this);
        BindUiElement();
        preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResearch();
                Intent intent = new Intent(ResearchInfoActivity.this, OtherDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BindUiElement() {
        researchName =  findViewById(R.id.edit_research_description);
        researchDesc =  findViewById(R.id.edit_research_name);
        researchLink =  findViewById(R.id.edit_research_link);
        professorName =  findViewById(R.id.edit_professor_name);

        nextBtn =  findViewById(R.id.btn_next);
    }
    private void addResearch(){
        String desc = researchDesc.getText().toString();
        String name = researchName.getText().toString();
        String link = researchLink.getText().toString();
        String prof = professorName.getText().toString();
        long rowId;

        long studentId = StudentInfoActivity.getCurrentStudentId(preferences);

        try {
            rowId = databaseHelper.addResearch(name, link, desc, prof, studentId);
            if (rowId != -1L) {
                // Insertion successful
                Toast.makeText(ResearchInfoActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
            } else {
                // Insertion failed
                Toast.makeText(ResearchInfoActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            Toast.makeText(ResearchInfoActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
        }

    }
}