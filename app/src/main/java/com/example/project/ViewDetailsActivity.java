package com.example.project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_info);
        databaseHelper = new DatabaseHelper(ViewDetailsActivity.this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Parse the XML data and create a list of Item objects
        List<Item> itemList = null;
        try {
            itemList = parseXmlData();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

        adapter = new MyAdapter(itemList, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                // Handle click event on a row
                Toast.makeText(ViewDetailsActivity.this, "Clicked: " + item.getName(), Toast.LENGTH_SHORT).show();

                long id = item.getId();
                Bundle bundle = new Bundle();
                bundle.putLong("id",id);
                Intent intent = new Intent(ViewDetailsActivity.this, FullDetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private List<Item> parseXmlData() throws ParserConfigurationException, IOException, SAXException {
        // Parse the XML data and return a list of Item objects
        // You can customize this based on your XML parsing logic
        // Example:
        List<Item> itemList = new ArrayList<>();
        // Parse XML and add Item objects to itemList
        // For demonstration purposes, let's add some dummy data
        // Retrieve the list of students from the database
        List<Student> studentList = getStudentsFromDatabase();

        // Iterate over the studentList and create Item objects
        for (Student student : studentList) {
            String name = student.getStudentName();
            String college = student.getCollegeName();
            String usn = student.getStudentUSN();
            String sem = student.getStudentSem();
            String dept = student.getStudentDept();
            long id = student.getId();
            itemList.add(new Item(id,name,college,usn,sem,dept));

        }

        return itemList;
    }
    private List<Student> getStudentsFromDatabase() {
        return databaseHelper.getAllStudents();
    }

    // Item class representing parsed XML data
    private static class Item {
        private String name;
        private String college;
        private String usn,sem,dept;

        private long id;

        public Item(long id,String name, String college,String usn,String sem,String dept) {
            this.id = id;
            this.name = name;
            this.college = college;
            this.usn = usn;
            this.sem = sem;
            this.dept = dept;
        }

        public String getName() {
            return name;
        }
        public String getStudentSem(){ return sem;}

        public String getStudentDept(){ return dept;}
        public long getId(){ return id; }
        public String getCollege() { return college; }

        public String getUsn() { return usn; }
    }

    // RecyclerView adapter
    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<Item> itemList;
        private OnItemClickListener onItemClickListener;

        public MyAdapter(List<Item> itemList, OnItemClickListener onItemClickListener) {
            this.itemList = itemList;
            this.onItemClickListener = onItemClickListener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_info, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item = itemList.get(position);
            holder.bindData(item);
            holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(item));
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView titleTextView;
            private TextView descriptionTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            }

            public void bindData(Item item) {
                // Bind XML data to views in the item layout
                titleTextView.setText("Name: "+item.getName());
                descriptionTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                descriptionTextView.setLineSpacing(0, 1.2f);
                descriptionTextView.setText(String.format("USN: %s\nCollege: %s\n Semester: %s  Department: %s", item.getUsn(), item.getCollege(),item.getStudentSem(),item.getStudentDept()));
            }

        }

        public interface OnItemClickListener {
            void onItemClick(Item item);
        }
    }
}
