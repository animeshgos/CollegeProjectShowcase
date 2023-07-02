package com.example.project;

public class Project {
    private long id;
    private String projectName;
    private String projectDesc;
    private String projectLink;

    public Project(long id, String projectName, String projectDesc, String projectLink) {
        this.id = id;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectLink = projectLink;
    }

    public long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public String getProjectLink() {
        return projectLink;
    }
}
