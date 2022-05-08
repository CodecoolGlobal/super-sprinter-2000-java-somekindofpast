package com.codecool.supersprinter2000.controller;

import com.codecool.supersprinter2000.model.UserStory;
import com.codecool.supersprinter2000.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/story/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("userStory", userStoryService.findUserStoryById(id));
        return "update";
    }

    @PostMapping("/story/{id}")
    public String updateStory(@PathVariable int id, @RequestParam String title, @RequestParam String story, @RequestParam String criteria, @RequestParam float value, @RequestParam int estimation, @RequestParam String status) {
        userStoryService.updateUserStory(id, new UserStory(title, story, criteria, value, estimation, status));
        return "redirect:/";
    }
}
