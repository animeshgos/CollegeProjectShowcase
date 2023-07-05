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

public class OtherDetailsActivity  extends AppCompatActivity{
    EditText creatEnd, promColab,recgn;
    Button nextBtn;
    private DatabaseHelper databaseHelper;

    private SharedPreferences preferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_info);

        databaseHelper = new DatabaseHelper(OtherDetailsActivity.this);

        BindUiElement();


        preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addOthers();
                Intent intent = new Intent(OtherDetailsActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });
    }



    private void BindUiElement() {
        creatEnd =  findViewById(R.id.edit_creative_endeavors);
        recgn =  findViewById(R.id.edit_recognition);
        promColab =  findViewById(R.id.edit_promoting_collaborations);

        nextBtn =  findViewById(R.id.btn_next);
    }
    private void addOthers(){
        String endaevor = creatEnd.getText().toString();
        String collab = promColab.getText().toString();
        String recogn = recgn.getText().toString();

        long rowId;

        long studentId = StudentInfoActivity.getCurrentStudentId(preferences);

        try {
            rowId = databaseHelper.addOthers(endaevor,collab,recogn, studentId);
            if (rowId != -1L) {
                // Insertion successful
                Toast.makeText(OtherDetailsActivity.this, "Other details Added", Toast.LENGTH_SHORT).show();
            } else {
                // Insertion failed
                Toast.makeText(OtherDetailsActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            Toast.makeText(OtherDetailsActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

}