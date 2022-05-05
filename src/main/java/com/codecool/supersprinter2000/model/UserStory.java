package com.codecool.supersprinter2000.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserStory {
    private int id;
    @JsonProperty("story_title")
    private String storyTitle;
    @JsonProperty("user_story")
    private String userStory;
    @JsonProperty("acceptance_criteria")
    private String acceptanceCriteria;
    @JsonProperty("business_value")
    private float businessValue;
    private String status;

    public UserStory(String storyTitle, String userStory, String acceptanceCriteria, float businessValue, String status) {
        this.storyTitle = storyTitle;
        this.userStory = userStory;
        this.acceptanceCriteria = acceptanceCriteria;
        this.businessValue = businessValue;
        this.status = status;
    }

    public UserStory() {
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
