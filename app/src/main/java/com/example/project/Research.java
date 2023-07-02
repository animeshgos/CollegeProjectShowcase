package com.example.project;

public class Research {
    private long id;
    private String researchName;
    private String researchDesc;
    private String researchProfName;
    private String researchLink;

    public Research(long id, String researchName, String researchDesc, String researchProfName, String researchLink) {
        this.id = id;
        this.researchName = researchName;
        this.researchDesc = researchDesc;
        this.researchProfName = researchProfName;
        this.researchLink = researchLink;
    }

    public long getId() {
        return id;
    }

    public String getResearchName() {
        return researchName;
    }

    public String getResearchDesc() {
        return researchDesc;
    }

    public String getResearchProfName() {
        return researchProfName;
    }

    public String getResearchLink() {
        return researchLink;
    }
}
