package com.gamja.learn_jpa_and_hibernate.course.jdbc;

import com.gamja.learn_jpa_and_hibernate.course.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
                delete from course
                where id = ?
            """;

    //조회를 위한 select 쿼리
    private static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    //이번에는 삭제하는 쿼리를 날리는 메서드를 작성해본다.
    public void delete(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    //select쿼리를 실행하고, 그 결과를 Course 객체에 매핑해서 반환한다.
    //매핑을 위해 BeanPropertyRowMapper를 사용했다.
    //BeanPropertyRowMapper는 RowMapper인터페이스의 구현체이다. 쿼리 결과를 자바 빈 객체로 자동 매핑해준다.
    //ResultSet의 컬럼 이름과 자바 빈의 프로퍼티 이름을 매칭해서 자동으로 값을 할당한다.
    //이때 자바 객체는 기본 생성자(인수가 없는 생성자)와 setter 메서드를 가져야 한다. 이걸 모르고 기본 생성자를 안만들어서 오류가 터지고 있었음.
    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);//조회 결과를 Course 빈으로 매핑한다. BeanPropertyRowMapper 사용
//ResultSet -> Bean => Row Mapper
    }
}
