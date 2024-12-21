package com.gamja.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//이번에는 JPA를 이용해본다. 빈과 테이블을 직접 매핑함.
@Entity
public class Course {//같은 이름의 테이블 course와 매핑된다.

    @Id
    private long id;

    //현재 필드이름과 테이블의 column이름이 같기 때문에 @Column(name = "name") 이 부분은 그냥 빼버려도 된다.
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

    public Course() {
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
