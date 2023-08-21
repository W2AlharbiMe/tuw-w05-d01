package com.example.homeworkweek05d1.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotEmpty(message = "the area field is required.")
    private String area;

    @NotEmpty(message = "the street field is required.")
    private String street;

    @NotNull(message = "the salary field is required.")
    private Integer buildingNumber;


    @NotNull(message = "the teacher id field is required.")
    private Integer teacherId;
}
