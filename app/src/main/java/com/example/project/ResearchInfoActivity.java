package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResearchInfoActivity  extends AppCompatActivity{
    EditText resName, profName,resLink,resDesc;
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
        resDesc = (EditText) findViewById(R.id.edit_research_description);
        resName = (EditText) findViewById(R.id.edit_research_name);
        resLink = (EditText) findViewById(R.id.edit_research_link);
        profName = (EditText) findViewById(R.id.edit_professor_name);

        nextBtn = (Button) findViewById(R.id.btn_next);
    }

}