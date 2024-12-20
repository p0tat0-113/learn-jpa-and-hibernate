package com.gamja.learn_jpa_and_hibernate.course.jdbc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //데이터베이스에 연결
public class CourseJdbcRepository {

    //JdbcTemplate을 AutoWiring 받는다. 이건 아마 스프링에서 주나본데...?
    @Autowired//이거 꼭 붙여야 의존성이 주입된다. 아니면 nullPointerException 터짐.
    private JdbcTemplate springJdbcTemplate;

    //""" 이렇게 큰따옴표를 세개 붙이면 텍스트 블록이 된다. sql쿼리의 형태를 그래도 유지할 수 있음.
    private static String INSERT_QUERY =
            """
                    insert into course(id,name,author)
                    values(1, 'Learn AWS', 'dongwoo');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
