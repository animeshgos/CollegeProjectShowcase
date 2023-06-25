package com.example.project;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.StudentInfoActivity;
import com.example.project.ViewDetailsActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername,txtPassword;
    Button addDetails,viewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindUiElements();

        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentInfoActivity.class);
                startActivity(intent);
            }
            }
        );
        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        }
        );
    }

    private void BindUiElements() {
        addDetails = (Button) findViewById(R.id.btn_add_details);
        viewDetails = (Button) findViewById(R.id.btn_view_details);
    }
}
