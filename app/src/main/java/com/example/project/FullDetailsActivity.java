package com.example.project;

import android.os.Bundle;
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
//        section1ContentTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//        section1ContentTextView.setLineSpacing(0, 1.2f);
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
        for (Project project : projectlist) {
            content.append("Project:   ").append(project.getProjectName()).append("\n\n");
            content.append("Description:   ").append(project.getProjectDesc()).append("\n\n");
            content.append("Link:   ").append(project.getProjectLink()).append("");
            long id = project.getId();
        }
        return content.toString();
    }

    private String getSection2Content() {
        Bundle bundle = getIntent().getExtras();
        long stud_id = bundle.getLong("id");
        List<Research> researchlist = databaseHelper.getResearchByStudentId(stud_id);
        StringBuilder content = new StringBuilder();
        for (Research research : researchlist) {
            content.append("Research:  ").append(research.getResearchName()).append("\n\n");
            content.append("Description:  ").append(research.getResearchDesc()).append("\n\n");
            content.append("Link:  ").append(research.getResearchLink()).append("\n\n");
            content.append("Professor's Name: ").append(research.getResearchProfName()).append("\n\n");
            long id = research.getId();
        }
        return content.toString();    }

    private String getSection3Content() {
        Bundle bundle = getIntent().getExtras();
        long stud_id = bundle.getLong("id");
        List<Others> otherlist = databaseHelper.getOtherDataByStudentId(stud_id);
        StringBuilder content = new StringBuilder();
        for (Others other : otherlist) {
            content.append("Endeavours:  ").append(other.getOtherEndeavor()).append("\n\n");
            content.append("Collaborations:  ").append(other.getOtherCollab()).append("\n\n");
            content.append("Recognition:  ").append(other.getOtherRecognition()).append("");
            long id = other.getId();
        }
        return content.toString();    }
    //yes

    private List<Student> getStudentsFromDatabase() {
        return databaseHelper.getAllStudents();
    }
}
