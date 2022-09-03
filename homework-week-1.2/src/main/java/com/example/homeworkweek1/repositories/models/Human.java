package com.example.homeworkweek1.repositories.models;


import org.jetbrains.annotations.NotNull;

public class Human implements Comparable<Human> {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public Human(Long id, String name, Integer age, String favorite) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favorite = favorite;
    }

    private Integer age;
    private String favorite;


    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favorite='" + favorite + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Human human) {
        return this.getAge().compareTo(human.getAge());
    }
}
