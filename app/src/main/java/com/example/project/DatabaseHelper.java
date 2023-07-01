package com.example.project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE_STUDENT = "students";
    private static final String TABLE_PROJECT = "projects";
    private static final String TABLE_RESEARCH = "research";

    // Common column names
    private static final String COLUMN_ID = "id";

    // Student table column names
    private static final String COLUMN_STUDENT_NAME = "student_name";
    private static final String COLUMN_COLLEGE_NAME = "college_name";
    private static final String COLUMN_STUDENT_USN = "student_usn";

    // Project table column names
    private static final String COLUMN_PROJECT_NAME = "project_name";

    private static final String COLUMN_PROJECT_DESC ="project_desc";

    private static final String COLUMN_PROJECT_LINK ="project_link";
    private static final String COLUMN_PROJECT_STUDENT_ID = "student_id";

    // Research table column names
    private static final String COLUMN_RESEARCH_NAME = "research_name";
    private static final String COLUMN_RESEARCH_DESC ="research_desc";

    private static final String COLUMN_RESEARCH_PROF_NAME = "research_prof_name";

    private static final String COLUMN_RESEARCH_LINK ="research_link";
    private static final String COLUMN_RESEARCH_STUDENT_ID = "student_id";

    public DatabaseHelper(StudentInfoActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create student table
        String createStudentTableQuery = "CREATE TABLE " + TABLE_STUDENT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUDENT_NAME + " TEXT, " +
                COLUMN_COLLEGE_NAME + " TEXT, " +COLUMN_STUDENT_USN + "TEXT" +
                ")";
        db.execSQL(createStudentTableQuery);

        // Create project table
        String createProjectTableQuery = "CREATE TABLE " + TABLE_PROJECT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PROJECT_NAME + " TEXT, "
                + COLUMN_PROJECT_DESC + "TEXT ,"
                + COLUMN_PROJECT_LINK + "TEXT ," +
                COLUMN_PROJECT_STUDENT_ID + " INTEGER, " +
                "FOREIGN KEY (" + COLUMN_PROJECT_STUDENT_ID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_ID + ")" +
                ")";
        db.execSQL(createProjectTableQuery);

        // Create research table
        String createResearchTableQuery = "CREATE TABLE " + TABLE_RESEARCH + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_RESEARCH_NAME + " TEXT, "
                + COLUMN_RESEARCH_DESC + "TEXT ,"
                + COLUMN_RESEARCH_LINK + "TEXT ,"
                + COLUMN_RESEARCH_PROF_NAME +"TEXT," +
                COLUMN_RESEARCH_STUDENT_ID + " INTEGER, " +
                "FOREIGN KEY (" + COLUMN_RESEARCH_STUDENT_ID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_ID + ")" +
                ")";
        db.execSQL(createResearchTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESEARCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    public long addStudent(String studentName, String collegeName,String studentUSN) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENT_NAME, studentName);
        values.put(COLUMN_COLLEGE_NAME, collegeName);
        values.put(COLUMN_STUDENT_USN,studentUSN);

        return db.insert(TABLE_STUDENT, null, values);
    }

    public long addProject(String projectName,String projectDesc, String projectLink,long studentId) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PROJECT_NAME, projectName);
        values.put(COLUMN_PROJECT_DESC, projectDesc);
        values.put(COLUMN_PROJECT_LINK, projectLink);
        values.put(COLUMN_PROJECT_STUDENT_ID, studentId);

        return db.insert(TABLE_PROJECT, null, values);
    }

    public long addResearch(String researchName, long studentId) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RESEARCH_NAME, researchName);
        values.put(COLUMN_RESEARCH_STUDENT_ID, studentId);

        return db.insert(TABLE_RESEARCH, null, values);
    }
}