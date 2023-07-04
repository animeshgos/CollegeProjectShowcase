package com.example.project;

public class Others {
    private long id;
    private String otherEndeavor;
    private String otherCollab;
    private String otherRecognition;

    public  Others (long id ,String otherEndeavor,String otherCollab,String otherRecognition){
        this.otherEndeavor = otherEndeavor;
        this.id = id;
        this.otherCollab  = otherCollab;
        this.otherRecognition = otherRecognition;
    }

    public String getOtherEndeavor(){return otherEndeavor;}
    public String getOtherCollab(){return otherCollab;}
    public String getOtherRecognition(){return otherRecognition;}

    public  long getId(){
        return id;
    }

}
