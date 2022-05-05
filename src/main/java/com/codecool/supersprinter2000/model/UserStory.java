package com.codecool.supersprinter2000.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserStory {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Story Title")
    private String storyTitle;
    @JsonProperty("User Story")
    private String userStory;
    @JsonProperty("Acceptance Criteria")
    private String acceptanceCriteria;
    @JsonProperty("Business Value")
    private float businessValue;
    @JsonProperty("Status")
    private String status;

    public UserStory(String storyTitle, String userStory, String acceptanceCriteria, float businessValue, String status) {
        this.storyTitle = storyTitle;
        this.userStory = userStory;
        this.acceptanceCriteria = acceptanceCriteria;
        this.businessValue = businessValue;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public float getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(float businessValue) {
        this.businessValue = businessValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
