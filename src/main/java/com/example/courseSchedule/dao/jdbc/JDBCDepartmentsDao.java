package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.DepartmentsDao;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCDepartmentsDao extends JDBCBaseDao<DepartmentEntity> implements DepartmentsDao {

    private final static String GET = "SELECT id, name FROM course_schedule.department";
    private final static String DELETE = "DELETE FROM course_schedule.department WHERE id = ?";
    private final static RowMapper<DepartmentEntity> ROW_MAPPER = (rs, rowNum) -> new DepartmentEntity(rs.getLong("id"), rs.getString("name"));

    private final JdbcTemplate jdbcTemplate;

    public JDBCDepartmentsDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, GET, DELETE, ROW_MAPPER);
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public void create(DepartmentEntity departmentDto) {
        jdbcTemplate.update("INSERT INTO course_schedule.department(id, name) VALUES (nextval('course_schedule.seq_department'), ?)", departmentDto.getName());
    }

}
