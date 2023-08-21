package com.example.homeworkweek05d1.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO {

    @NotEmpty(message = "the name field is required.")
    private String name;

    @NotNull(message = "the salary field is required.")
    private Integer age;

    @NotEmpty(message = "the email field is required.")
    @Email(message = "the email must be valid.")
    private String email;

    @NotNull(message = "the salary field is required.")
    private Double salary;

}
