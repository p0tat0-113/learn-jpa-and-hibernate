package com.gamja.learn_jpa_and_hibernate.course;

public class Course {
    private long id;
    private String name;
    private String author;

    public Course() {//BeanPropertyRowMapper에 의해 자동으로 매핑되기 위해서는 기본생성자와 setter메서드를 가지고 있어야 한다.
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
