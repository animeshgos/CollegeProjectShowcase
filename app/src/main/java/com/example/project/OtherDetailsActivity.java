package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtherDetailsActivity  extends AppCompatActivity{
    EditText creatEnd, promColab,recgn;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_info);

        BindUiElement();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherDetailsActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BindUiElement() {
        creatEnd = (EditText) findViewById(R.id.edit_creative_endeavors);
        recgn = (EditText) findViewById(R.id.edit_recognition);
        promColab = (EditText) findViewById(R.id.edit_promoting_collaborations);

        nextBtn = (Button) findViewById(R.id.btn_next);
    }

}