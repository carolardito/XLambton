package com.example.carolina.xlambton.model;

public class Photos {

    private Long id;
    private Long agentID;
    /*private String missionPhoto;
    private String missionPhotoName;*/
    private boolean photoSelected1 = false;
    private boolean photoSelected2 = false;
    private boolean photoSelected3 = false;
    private boolean photoSelected4 = false;
    private String missionPhoto1;
    private String missionPhoto2;
    private String missionPhoto3;
    private String missionPhoto4;

    /*public Photos(int id, String agentID, String missionPhoto) {
        this.id = id;
        this.agentID = agentID;
        this.missionPhoto = missionPhoto;
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

    /*public String getMissionPhoto() {
        return missionPhoto;
    }

    public void setMissionPhoto(String missionPhoto1) {
        this.missionPhoto = missionPhoto1;
    }

    public String getMissionPhotoName() {
        return missionPhotoName;
    }

    public void setMissionPhotoName(String missionPhotoName) {
        this.missionPhotoName = missionPhotoName;
    }

    public boolean getPhotoSelected() {
        return photoSelected;
    }

    public void setPhotoSelected(boolean photoSelected) {
        this.photoSelected = photoSelected;
    }

    public void undoPhotoSelected() {
        this.photoSelected = !photoSelected;
    }*/

    public String getMissionPhoto1() {
        return missionPhoto1;
    }

    public void setMissionPhoto1(String missionPhoto1) {
        this.missionPhoto1 = missionPhoto1;
    }

    public boolean isPhotoSelected1() {
        return photoSelected1;
    }

    public void setPhotoSelected1(boolean photoSelected1) {
        this.photoSelected1 = photoSelected1;
    }

    public void undoPhotoSelected1() {
        this.photoSelected1 = !photoSelected1;
    }

    public String getMissionPhoto2() {
        return missionPhoto2;
    }

    public void setMissionPhoto2(String missionPhoto2) {
        this.missionPhoto2 = missionPhoto2;
    }

    public boolean isPhotoSelected2() {
        return photoSelected2;
    }

    public void setPhotoSelected2(boolean photoSelected2) {
        this.photoSelected2 = photoSelected2;
    }

    public void undoPhotoSelected2() {
        this.photoSelected2 = !photoSelected2;
    }

    public String getMissionPhoto3() {
        return missionPhoto3;
    }

    public void setMissionPhoto3(String missionPhoto3) {
        this.missionPhoto3 = missionPhoto3;
    }

    public boolean isPhotoSelected3() {
        return photoSelected3;
    }

    public void setPhotoSelected3(boolean photoSelected3) {
        this.photoSelected3 = photoSelected3;
    }

    public void undoPhotoSelected3() {
        this.photoSelected3 = !photoSelected3;
    }

    public String getMissionPhoto4() {
        return missionPhoto4;
    }

    public void setMissionPhoto4(String missionPhoto4) {
        this.missionPhoto4 = missionPhoto4;
    }

    public boolean isPhotoSelected4() {
        return photoSelected4;
    }

    public void setPhotoSelected4(boolean photoSelected4) {
        this.photoSelected4 = photoSelected4;
    }

    public void undoPhotoSelected4() {
        this.photoSelected4 = !photoSelected4;
    }
}
