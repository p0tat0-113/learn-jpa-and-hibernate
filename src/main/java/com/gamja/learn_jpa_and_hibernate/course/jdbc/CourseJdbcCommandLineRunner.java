package com.gamja.learn_jpa_and_hibernate.course.jdbc;

import com.gamja.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {//CommandLineRunner 인터페이스를 구현함. 스프링 시작시 실행되어야할 로직이 있으면 이걸 사용할 수 있다.

    @Autowired
    private CourseJdbcRepository courseJdbcRepository; //CourseJdbcRepository 빈을 AutoWiring 받는다.

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "LearnAWS", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.
        courseJdbcRepository.insert(new Course(2, "LearnMachineLearning", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.
        courseJdbcRepository.insert(new Course(3, "LearnAzure", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.

        courseJdbcRepository.delete(3);//id가 3인 튜플을 삭제
    }
}
