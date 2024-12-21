package com.gamja.learn_jpa_and_hibernate.course.jpa;

import com.gamja.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional//JPA로 쿼리를 실행할 때마다 트랜잭션을 허용해줘야 한다. 처음에 이게 없어서 No EntityManager with actual transaction available for current thread - cannot reliably process 'merge' call 오류내면서 뻗었음.
public class CourseJpaRepository {

    //JPA를 사용해서 데이터베이스에 연결하려면 EntityManager라는 것이 필요하다.
    //@Autowired
    @PersistenceContext //영속성 컨텍스트, entity manager를 빈으로 주입할 때 사용하는 애노테이션
    private EntityManager entityManager;

    public void insert(Course course) {
        //튜플을 삽입할 때는 merge 메서드를 사용한다.
        entityManager.merge(course);//매핑이 이미 만들어져 있기 떄문에 그냥 Course 객체를 넘기기만 하면 알아서 된다.
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);//find()로 간단하게 찾아올 수 있음.
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);//먼저 해당 객체를 찾아온 다음에 제거한다.
        entityManager.remove(course);
    }
}
