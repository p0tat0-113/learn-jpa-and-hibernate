package com.gamja.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {//CommandLineRunner 인터페이스를 구현함. 스프링 시작시 실행되어야할 로직이 있으면 이걸 사용할 수 있다.

    @Autowired
    private CourseJdbcRepository courseJdbcRepository; //CourseJdbcRepository 빈을 AutoWiring 받는다.

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert();///스프링 시작과 동시에 insert() 메서드를 실행해서 h2 데이터베이스에 쿼리를 실행한다.
    }
}
