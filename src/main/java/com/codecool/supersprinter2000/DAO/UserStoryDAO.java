package com.codecool.supersprinter2000.DAO;

import com.codecool.supersprinter2000.model.UserStory;

import java.util.List;

public interface UserStoryDAO {
    List<UserStory> findAllUserStories();
    UserStory findUserStoryById(long id);
    long addUserStory(UserStory userStory);
    void updateUserStory(long id, UserStory userStory);
}
