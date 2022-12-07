package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Resultados {

    @SerializedName("name")
    @Expose
    public String superName;
    @SerializedName("realname")
    @Expose
    public String realName;
    @SerializedName("team")
    @Expose
    public String team;
    @SerializedName("firstappearance")
    @Expose
    public String appearance;
    @SerializedName("createdby")
    @Expose
    public String creador;
    @SerializedName("publisher")
    @Expose
    public String publisher;
    @SerializedName("bio")
    @Expose
    public String bio;
    private String mId;









    public Resultados(String name, String realName, String team, String appearance, String creador, String publisher, String bio ){
        mId = UUID.randomUUID().toString();
        this.superName=name;
        this.realName=realName;
        this.team=team;
        this.appearance=appearance;
        this.creador=creador;
        this.publisher=publisher;
        this.bio=bio;


    }
    public String getId() {
        return mId;
    }
    public void setId() {mId = UUID.randomUUID().toString();}

    public String getName(){
        return superName;
    }

    public String getRealName() {
        return realName;
    }

    public String getTeam() {
        return team;
    }

    public String getAppearance() {
        return appearance;
    }

    public String getCreador() {
        return creador;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBio() {
        return bio;
    }
}
