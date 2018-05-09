package com.example.carolina.xlambton.model;

public class Historical {

    private Long id;
    private Long agentID;
    private String missionName;
    private String date;
    private String status;

    /*public Historical(int id, String agentID, String missionName, String date, String status) {
        this.id = id;
        this.agentID = agentID;
        this.missionName = missionName;
        this.date = date;
        this.status = status;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentID() {
        return agentID;
    }

    public void setAgentID(Long agentID) {
        this.agentID = agentID;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
