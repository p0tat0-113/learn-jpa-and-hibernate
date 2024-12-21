package com.gamja.learn_jpa_and_hibernate.course.springdatajpa;

import com.gamja.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//이번에는 JPA를 더욱 간단하게 사용할 수 있게 해주는 SpringDataJpa를 사용해본다. 우선 인터페이스를 하나 만들고, JpaRepository를 상속한다 얘의 제네릭 타입으로 관리한 엔티티인 Course와 키 타입인 Long을 넣어준다.
//이제 EntityManager를 신경 쓸 필요도 없다. 그것 마저 백그라운드에서 이루어진다. 그냥 인터페이스 하나 만들고 JpaRepository를 상속하기만 했는데도 필요한 메서드들이 자동으로 제공된다.
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

}
