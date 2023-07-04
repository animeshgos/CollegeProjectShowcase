package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FullDetailsActivity extends AppCompatActivity {

    private LinearLayout section1Layout;
    private LinearLayout section2Layout;
    private LinearLayout section3Layout;

    private TextView section1ContentTextView;
    private TextView section2ContentTextView;
    private TextView section3ContentTextView;

    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accordion);

        databaseHelper = new DatabaseHelper(FullDetailsActivity.this);

        // Initialize section layouts
        section1Layout = findViewById(R.id.section1Layout);
        section2Layout = findViewById(R.id.section2Layout);
        section3Layout = findViewById(R.id.section3Layout);

        // Initialize section content TextViews
        section1ContentTextView = findViewById(R.id.section1ContentTextView);
        section2ContentTextView = findViewById(R.id.section2ContentTextView);
        section3ContentTextView = findViewById(R.id.section3ContentTextView);

        // Set click listeners for section headers
        section1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSectionVisibility(section1ContentTextView);
            }
        });

        section2Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSectionVisibility(section2ContentTextView);
            }
        });

        section3Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSectionVisibility(section3ContentTextView);
            }
        });

        // Set content for each section
        section1ContentTextView.setText(getSection1Content());
        section2ContentTextView.setText(getSection2Content());
        section3ContentTextView.setText(getSection3Content());
    }

    private void toggleSectionVisibility(TextView contentTextView) {
        if (contentTextView.getVisibility() == View.VISIBLE) {
            contentTextView.setVisibility(View.GONE);
        } else {
            contentTextView.setVisibility(View.VISIBLE);
        }
    }

    private String getSection1Content() {
        Bundle bundle = getIntent().getExtras();
        long stud_id = bundle.getLong("id");
        List<Project> projectlist = databaseHelper.getProjectsByStudentId(stud_id);
        StringBuilder content = new StringBuilder();
        Log.d("studnetid","idid" + projectlist);
        for (Project project : projectlist) {
//            String name = project.getProjectName();
//            String desc = project.getProjectDesc();
//            String link = project.getProjectLink();
            Log.d("project","projectdata" + project);
            content.append("Project: ").append(project.getProjectName()).append("\n");
            content.append("Description: ").append(project.getProjectDesc()).append("\n");
            content.append("Link: ").append(project.getProjectLink()).append("\n\n");
            long id = project.getId();
//            projectlist.add(new FullDetailsActivity().Item(id,name,desc,link));
        }
        Log.d("string","stg"+content.toString());
        return content.toString();
    }

    private String getSection2Content() {
        return "This is the content for section 2.";
    }

    private String getSection3Content() {
        return "This is the content for section 3.";
    }

    private List<Student> getStudentsFromDatabase() {
        return databaseHelper.getAllStudents();
    }
}
