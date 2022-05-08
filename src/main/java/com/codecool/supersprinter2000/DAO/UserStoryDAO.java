package com.codecool.supersprinter2000.DAO;

import com.codecool.supersprinter2000.model.UserStory;

import java.util.List;

public interface UserStoryDAO {
    List<UserStory> findAllUserStories();
    UserStory findUserStoryById(int id);
    int addUserStory(UserStory userStory);
    void updateUserStory(int id, UserStory userStory);
}
