package com.codecool.supersprinter2000.controller;

import com.codecool.supersprinter2000.model.UserStory;
import com.codecool.supersprinter2000.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserStoryController {
    private UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userStories", userStoryService.findAllUserStories());
        return "index";
    }

    @GetMapping("/story")
    public String story() {
        return "story";
    }

    @PostMapping("/story")
    public String addStory(@RequestParam String title, @RequestParam String story, @RequestParam String criteria, @RequestParam float value, @RequestParam int estimation) {
        userStoryService.addUserStory(new UserStory(title, story, criteria, value, estimation, "in progress"));
        return "redirect:/";
    }

    //public UserStory findUserStoryById(long id) {
    //    return userStoryService.findUserStoryById(id);
    //}

    //public long addUserStory(UserStory userStory) {
    //    return userStoryService.addUserStory(userStory);
    //}

    //public void updateUserStory(long id, UserStory userStory) {
    //    userStoryService.updateUserStory(id, userStory);
    //}
}
