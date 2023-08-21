package com.example.homeworkweek05d1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Email(message = "the email must be valid.")
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Double salary;

    // relation
    @OneToOne(cascade = CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    private Address address;

}
