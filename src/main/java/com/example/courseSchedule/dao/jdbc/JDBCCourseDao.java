package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.CoursesDao;
import com.example.courseSchedule.dao.entity.CourseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCCourseDao extends JDBCBaseDao<CourseEntity> implements CoursesDao {

    private final static String GET = "SELECT id, name, department_id, credits FROM course_schedule.course";
    private final static String DELETE = "DELETE FROM course_schedule.course WHERE id = ?";
    private final static RowMapper<CourseEntity> ROW_MAPPER = (rs, rowNum) ->
            new CourseEntity(rs.getLong("id"), rs.getString("name"), rs.getLong("department_id"), rs.getInt("credits"));

    private final JdbcTemplate jdbcTemplate;

    public JDBCCourseDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, GET, DELETE, ROW_MAPPER);
        this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void create(CourseEntity courseEntity) {
        jdbcTemplate.update("INSERT INTO course_schedule.course(id, name, department_id, credits) VALUES (nextval('course_schedule.seq_course'), ?, ?, ?)",
                courseEntity.getName(), courseEntity.getDepartmentId(), courseEntity.getCredits());
    }

}
