package com.codecool.supersprinter2000.service;

import com.codecool.supersprinter2000.DAO.UserStoryDAO;
import com.codecool.supersprinter2000.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {
    @Qualifier("jdbc")
    private UserStoryDAO userStoryDAO;

    @Autowired
    public UserStoryService(UserStoryDAO userStoryDAO) {
        this.userStoryDAO = userStoryDAO;
    }

    public List<UserStory> findAllUserStories() {
        return userStoryDAO.findAllUserStories();
    }

    public UserStory findUserStoryById(int id) {
        return userStoryDAO.findUserStoryById(id);
    }

    public int addUserStory(UserStory userStory) {
        return userStoryDAO.addUserStory(userStory);
    }

    public void updateUserStory(int id, UserStory userStory) {
        userStoryDAO.updateUserStory(id, userStory);
    }
}
