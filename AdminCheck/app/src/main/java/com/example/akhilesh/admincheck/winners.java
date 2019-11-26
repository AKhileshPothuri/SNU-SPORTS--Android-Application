package com.example.akhilesh.admincheck;

public class winners {
    private String team1, team2, sports,leagueName;
    private int team1_score, team2_score, live;

    public winners() {
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public int getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(int team1_score) {
        this.team1_score = team1_score;
    }

    public int getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(int team2_score) {
        this.team2_score = team2_score;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }
}
