package com.example.homeworkweek05d1.Controller;

import com.example.homeworkweek05d1.Model.Course;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Course> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Course> add(@RequestBody @Valid Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Course> update(@PathVariable Integer id, @RequestBody @Valid Course course) {
        return ResponseEntity.ok(courseService.update(id, course));
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity<Teacher> update(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        return ResponseEntity.ok(courseService.assignCourseToTeacher(courseId, teacherId));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.delete(id));
    }
}
