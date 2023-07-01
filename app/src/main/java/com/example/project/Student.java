package com.example.project;

public class Student {
    private long id;
    private String studentName;
    private String collegeName;
    private String studentUSN;

    public Student(long id, String studentName, String collegeName, String studentUSN) {
        this.id = id;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.studentUSN = studentUSN;
    }

    public long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getStudentUSN() {
        return studentUSN;
    }
}
