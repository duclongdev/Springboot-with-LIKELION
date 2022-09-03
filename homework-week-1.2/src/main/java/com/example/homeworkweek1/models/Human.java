package com.example.homeworkweek1.models;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;


@Entity
@Data
@Table(name="HUMAN")
@NoArgsConstructor
public class Human implements Comparable<Human> {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String favorite;

    @Override
    public int compareTo(@NotNull Human human) {
        return this.getAge().compareTo(human.getAge());
    }
}
