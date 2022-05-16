package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.ScheduleDao;
import com.example.courseSchedule.dao.entity.ScheduleEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class JDBCSchedulesDao implements ScheduleDao {

    private final static String GET = "SELECT professor_id, course_id, year, semester FROM course_schedule.schedule";
    private final static String DELETE = "DELETE FROM course_schedule.schedule WHERE professor_id = ? and course_id = ?";
    private final static RowMapper<ScheduleEntity> ROW_MAPPER = (rs, rowNum) ->
            new ScheduleEntity(rs.getLong("professor_id"), rs.getLong("course_id"), rs.getInt("year"), rs.getInt("semester"));

    private final JdbcTemplate jdbcTemplate;

    public JDBCSchedulesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ScheduleEntity> getAll() {
        return jdbcTemplate.query(GET, ROW_MAPPER);
    }

    @Override
    public List<ScheduleEntity> getByProfessorId(Long id) {
        return jdbcTemplate.query(GET + " WHERE professor_id = ?", ROW_MAPPER, id);
    }

    @Override
    public List<ScheduleEntity> getByCourseId(Long id) {
        return jdbcTemplate.query(GET + " WHERE course_id = ?", ROW_MAPPER, id);
    }

    @Override
    public void create(ScheduleEntity scheduleEntity) {
        jdbcTemplate.update("INSERT INTO course_schedule.schedule(professor_id, course_id, year, semester) VALUES (?, ?, ?, ?)",
                scheduleEntity.getProfessorId(), scheduleEntity.getCourseId(), scheduleEntity.getYear(), scheduleEntity.getSemester());
    }

    @Override
    public void remove(Long professorId, Long courseId) {
        jdbcTemplate.update(DELETE, professorId, courseId);
    }
}
