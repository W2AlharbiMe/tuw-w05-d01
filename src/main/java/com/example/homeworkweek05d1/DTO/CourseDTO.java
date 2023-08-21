package com.example.homeworkweek05d1.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {


    @NotEmpty(message = "the name field is required.")
    private String name;



    @NotNull(message = "the teacher field is required.")
    private Integer teacherId;


}
