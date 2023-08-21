package com.example.homeworkweek05d1.Controller;

import com.example.homeworkweek05d1.DTO.TeacherDTO;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeachersController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(teacherService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> add(@RequestBody @Valid TeacherDTO teacherDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.add(teacherDTO));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Integer id, @RequestBody @Valid TeacherDTO teacherDTO) {
        return ResponseEntity.ok(teacherService.update(id, teacherDTO));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(teacherService.delete(id));
    }
}
