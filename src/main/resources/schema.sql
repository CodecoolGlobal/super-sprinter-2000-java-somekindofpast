DROP TABLE IF EXISTS user_stories CASCADE;
DROP SEQUENCE IF EXISTS user_stories_id_seq;
CREATE TABLE user_stories
(
    id                      int identity NOT NULL PRIMARY KEY,
    story_title             varchar(100),
    user_story              varchar(400),
    acceptance_criteria     varchar(400),
    business_value          float,
    status                  varchar(20)
);