package com.example.project;

public class Student {
    private long id;
    private String studentName;
    private String collegeName;
    private String studentUSN;

    private String studentSem;
    private  String studentDept;

    public Student(long id, String studentName, String collegeName, String studentUSN,String studentSem,String studentDept) {
        this.id = id;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.studentUSN = studentUSN;
        this.studentSem = studentSem;
        this.studentDept = studentDept;
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

    public String getStudentSem() { return studentSem; }
    public  String getStudentDept() { return studentDept; }
}
