package com.example.homeworkweek05d1.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String objectName;
    private String defaultMessage;
    private String field;
    private String code;
}
