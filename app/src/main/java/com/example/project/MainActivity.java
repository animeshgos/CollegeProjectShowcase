package com.example.project;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button addDetails,viewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindUiElements();

        addDetails.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, StudentInfoActivity.class);
            startActivity(intent);
        }
        );
        viewDetails.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewDetailsActivity.class);
            startActivity(intent);
        }
        );
    }

    private void BindUiElements() {
        addDetails = findViewById(R.id.btn_add_details);
        viewDetails = findViewById(R.id.btn_view_details);
    }
}
