package com.codecool.supersprinter2000.DAO.mapper;

import com.codecool.supersprinter2000.model.UserStory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserStoryMapper implements RowMapper<UserStory> {
    @Override
    public UserStory mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserStory userStory = new UserStory();
        userStory.setId(rs.getInt("id"));
        userStory.setStoryTitle(rs.getString("story_title"));
        userStory.setUserStory(rs.getString("user_story"));
        userStory.setAcceptanceCriteria(rs.getString("acceptance_criteria"));
        userStory.setBusinessValue(rs.getFloat("business_value"));
        userStory.setStatus(rs.getString("status"));
        return userStory;
    }
}
