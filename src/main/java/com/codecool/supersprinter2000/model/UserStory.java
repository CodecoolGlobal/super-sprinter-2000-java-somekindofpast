package com.codecool.supersprinter2000.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserStory {

    private int id;

    @Size(min = 5, max = 100, message = "String length should remain between 5 and 100 characters")
    @NotBlank
    @JsonProperty("story_title")
    private String storyTitle;

    @Size(min = 1, max = 400, message = "String length should remain between 1 and 400 characters")
    @NotBlank
    @JsonProperty("user_story")
    private String userStory;

    @Size(min = 1, max = 400, message = "String length should remain between 1 and 400 characters")
    @NotBlank
    @JsonProperty("acceptance_criteria")
    private String acceptanceCriteria;

    @DecimalMin("0.5")
    @DecimalMax("40.0")
    @JsonProperty("business_value")
    private float businessValue;

    private int estimation;

    @Size(min = 1, max = 20, message = "String length should remain between 1 and 20 characters")
    @NotBlank
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

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
