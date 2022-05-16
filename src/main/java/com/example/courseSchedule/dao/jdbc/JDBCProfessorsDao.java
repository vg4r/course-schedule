package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.ProfessorsDao;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCProfessorsDao extends JDBCBaseDao<ProfessorEntity> implements ProfessorsDao {

    private final static String GET = "SELECT id, name, department_id FROM course_schedule.professor";
    private final static String DELETE = "DELETE FROM course_schedule.professor WHERE id = ?";
    private final static RowMapper<ProfessorEntity> ROW_MAPPER = (rs, rowNum) ->
            new ProfessorEntity(rs.getLong("id"), rs.getString("name"), new DepartmentEntity().setId(rs.getLong("department_id")));

    private final JdbcTemplate jdbcTemplate;

    public JDBCProfessorsDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, GET, DELETE, ROW_MAPPER);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(ProfessorEntity professorEntity) {
        jdbcTemplate.update("INSERT INTO course_schedule.professor(id, name, department_id) VALUES (nextval('course_schedule.seq_professor'), ?, ?)", professorEntity.getName(), professorEntity.getDepartment().getId());
    }

}
