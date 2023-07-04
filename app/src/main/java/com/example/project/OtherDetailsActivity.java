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

    private DatabaseHelper databaseHelper;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_info);

        databaseHelper = new DatabaseHelper(OtherDetailsActivity.this);
<<<<<<< HEAD

=======
>>>>>>> c811f6e539e6ad06f4b0c361616b29ad9b45863e
        BindUiElement();
        preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);


        preferences = getSharedPreferences("MyPreferences.xml", Context.MODE_PRIVATE);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
//                addOtherDetails();
=======
                addOthers();
>>>>>>> c811f6e539e6ad06f4b0c361616b29ad9b45863e
                Intent intent = new Intent(OtherDetailsActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void addOtherDetails() {
//        String  name = creatEnd.getText().toString();
//        String description = recgn.getText().toString();
//        String  link = promColab.getText().toString();
//
//        long rowId;
//        long studentId = StudentInfoActivity.getCurrentStudentId(preferences);
//        try {
//            rowId = databaseHelper.addOtherDetails(name, description,link ,studentId);
//            if (rowId != -1L) {
//                // Insertion successful
//                Toast.makeText(OtherDetailsActivity.this, "Other Details Added", Toast.LENGTH_SHORT).show();
//            } else {
//                // Insertion failed
//                Toast.makeText(OtherDetailsActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
//            }
//        } catch (SQLException e) {
//            String errorMessage = e.getMessage();
//            Toast.makeText(OtherDetailsActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
//        }
//    }

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
                Toast.makeText(OtherDetailsActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
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