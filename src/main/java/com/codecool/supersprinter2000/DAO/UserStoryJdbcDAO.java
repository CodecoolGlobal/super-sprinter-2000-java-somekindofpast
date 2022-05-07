package com.codecool.supersprinter2000.DAO;

import com.codecool.supersprinter2000.DAO.mapper.UserStoryMapper;
import com.codecool.supersprinter2000.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@Qualifier("jdbc")
public class UserStoryJdbcDAO implements UserStoryDAO {

    private JdbcTemplate jdbcTemplate;
    private UserStoryMapper userStoryMapper;

    @Autowired
    public UserStoryJdbcDAO(JdbcTemplate jdbcTemplate, UserStoryMapper userStoryMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userStoryMapper = userStoryMapper;
    }

    @Override
    public List<UserStory> findAllUserStories() {
        String sql = "SELECT id, story_title, user_story, acceptance_criteria, business_value, estimation, status FROM user_stories";
        return jdbcTemplate.query(sql, userStoryMapper);
    }

    @Override
    public UserStory findUserStoryById(long id) {
        String sql = "SELECT id, story_title, user_story, acceptance_criteria, business_value, estimation, status FROM user_stories WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userStoryMapper, id);
    }

    @Override
    public int addUserStory(UserStory userStory) {
        String sql = "INSERT INTO user_stories(story_title, user_story, acceptance_criteria, business_value, estimation, status) VALUES (?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(getPreparedStatementCreator(userStory, sql), keyHolder);
        return (int)keyHolder.getKeys().get("id");
    }

    private PreparedStatementCreator getPreparedStatementCreator(UserStory userStory, String sql) {
        return connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userStory.getStoryTitle());
            statement.setString(2, userStory.getUserStory());
            statement.setString(3, userStory.getAcceptanceCriteria());
            statement.setFloat(4, userStory.getBusinessValue());
            statement.setInt(5, userStory.getEstimation());
            statement.setString(6, userStory.getStatus());
            return statement;
        };
    }

    @Override
    public void updateUserStory(long id, UserStory userStory) {
        String sql = "UPDATE user_stories SET story_title = ?, user_story = ?, acceptance_criteria = ?, business_value = ?, estimation = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, userStory.getStoryTitle(), userStory.getUserStory(), userStory.getAcceptanceCriteria(), userStory.getBusinessValue(), userStory.getEstimation(), userStory.getStatus(), id);
    }
}
