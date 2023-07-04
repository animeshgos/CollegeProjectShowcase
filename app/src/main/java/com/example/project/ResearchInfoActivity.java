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

public class ResearchInfoActivity  extends AppCompatActivity{
    EditText researchName, professorName,researchLink,researchDesc;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research_info);

        BindUiElement();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

}