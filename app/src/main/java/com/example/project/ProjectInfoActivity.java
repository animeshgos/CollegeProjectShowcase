package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectInfoActivity  extends AppCompatActivity{
    EditText projectName, projectDesc,projectLink;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);

        BindUiElement();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectInfoActivity.this, ResearchInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BindUiElement() {
        projectName = (EditText) findViewById(R.id.edit_project_name);
        projectDesc = (EditText) findViewById(R.id.edit_project_description);
        projectLink = (EditText) findViewById(R.id.edit_project_link);

        nextBtn = (Button) findViewById(R.id.btn_next);
    }

}