package com.gamja.learn_jpa_and_hibernate.course;

import com.gamja.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.gamja.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CourseJpaRepository의 메서드를 호출하게 코드를 바꾼다.
@Component
public class CourseCommandLineRunner implements CommandLineRunner {//CommandLineRunner 인터페이스를 구현함. 스프링 시작시 실행되어야할 로직이 있으면 이걸 사용할 수 있다.

    //@Autowired
    //private CourseJdbcRepository courseJdbcRepository; //CourseJdbcRepository 빈을 AutoWiring 받는다.

    //@Autowired
    //private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "LearnAWS", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.
        repository.save(new Course(2, "LearnMachineLearning", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.
        repository.save(new Course(3, "LearnAzure", "dongwoo"));//이렇게 sql쿼리 문에 인자를 삽입할 수 있다.

        repository.deleteById(3l);//id가 3인 튜플을 삭제

        System.out.println(repository.findById(1l));//id값이 1,2인 튜플을 조회
        System.out.println(repository.findById(2l));
    }
}
