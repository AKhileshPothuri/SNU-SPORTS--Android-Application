package com.example.akhilesh.aaaaa;

public class highlights {

    private String leaguename;
    private String sports;
    private String highlight;
    private String url;

    public highlights(){}

    public highlights(String leaguename, String sports, String highlight,String url) {
        this.leaguename = leaguename;
        this.sports = sports;
        this.highlight = highlight;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLeagueId() {
        return leaguename;
    }

    public void setLeagueId(String leagueId) {
        this.leaguename = leagueId;
    }

    public String getSport() {
        return sports;
    }

    public void setSport(String sport) {
        this.sports = sport;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
