package com.gamja.learn_jpa_and_hibernate.course.jdbc;

import com.gamja.learn_jpa_and_hibernate.course.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //데이터베이스에 연결
public class CourseJdbcRepository {

    //JdbcTemplate을 AutoWiring 받는다. 이건 아마 스프링에서 주나본데...?
    @Autowired//이거 꼭 붙여야 의존성이 주입된다. 아니면 nullPointerException 터짐.
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into course(id,name,author)
                values(?, ?, ?);
            """;
            //전에 했던 것처럼 삽입되는 값들을 하드코딩 하지 않고, 별도의 인자로 넣을 것이다. 이럴 때는 ?로 표시하면 됨.

    private static String DELETE_QUERY =
            """
                delete from course where id = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    //이번에는 삭제하는 쿼리를 날리는 메서드를 작성해본다.
    public void delete(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
}
