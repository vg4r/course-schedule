package com.example.courseSchedule.dao.jdbc;

import com.example.courseSchedule.dao.SearchDao;
import com.example.courseSchedule.dao.entity.CourseEntity;
import com.example.courseSchedule.dao.entity.DepartmentEntity;
import com.example.courseSchedule.dao.entity.ProfessorEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDBCSearchDao implements SearchDao {

    private final static String GET = "SELECT p.name professor_name, ARRAY_AGG(c.name) courses" +
            "\n FROM course_schedule.professor p" +
            "\n INNER JOIN course_schedule.department d ON p.department_id = d.id" +
            "\n INNER JOIN course_schedule.course c ON c.department_id = d.id" +
            "\n INNER JOIN course_schedule.schedule s ON s.course_id = c.id AND s.professor_id = p.id" +
            "\n GROUP BY p.name";

    private final static RowMapper<ProfessorEntity> ROW_MAPPER = (rs, rowNum) -> {
        Array coursesArray = rs.getArray("courses");
        List<CourseEntity> courses = Stream.of((String [])coursesArray.getArray()).map(e -> new CourseEntity().setName(e))
                .collect(Collectors.toList());
        return new ProfessorEntity(null, rs.getString("professor_name"), new DepartmentEntity().setCourses(courses));
    };

    private final JdbcTemplate jdbcTemplate;

    public JDBCSearchDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProfessorEntity> search() {
        return jdbcTemplate.query(GET, ROW_MAPPER);
    }

}
