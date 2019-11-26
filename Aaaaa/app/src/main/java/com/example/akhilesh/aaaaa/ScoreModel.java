package com.example.akhilesh.aaaaa;

public class ScoreModel {

    private String team1;
    private String team2;
    private String sports;
    private String leagueName;
    private int live;
    private String live_str;
    private int team1_score;
    private int team2_score;
    private int imageurl;


//    public ScoreModel(String team1, String team2, String team1_score, String team2_score, boolean live) {
//        this.team1 = team1;
//        this.team2 = team2;
//        this.team1_score = team1_score;
//        this.team2_score = team2_score;
//        this.live = live;
//    }

    public String getteam1() {
        return team1;
    }

    public String getteam2() {
        return team2;
    }

    public int getteam1_score() {
        return team1_score;
    }

    public int getteam2_score() {
        return team2_score;
    }

    public void setteam1(String team1) {
        this.team1 = team1;
    }

    public void setteam2(String team2) {
        this.team2 = team2;
    }

    public void setteam1_score(int team1_score) {
        this.team1_score = team1_score;
    }

    public void setteam2_score(int team2_score) {
        this.team2_score = team2_score;
    }
    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLive_str() {
        return live_str;
    }

    public void setLive_str(String live_str) {
        this.live_str = live_str;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
