package com.example.homeworkweek05d1.Service;

import com.example.homeworkweek05d1.Api.ApiException;
import com.example.homeworkweek05d1.DTO.CourseDTO;
import com.example.homeworkweek05d1.Model.Course;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Repository.CourseRepository;
import com.example.homeworkweek05d1.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> findAll() {
        return courseRepository.findAll();
    }


    public Course findById(Integer id) {
        Course course = courseRepository.findCourseById(id);

        if(course == null) {
            throw new ApiException("course not found.");
        }


        return course;
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Integer id, Course course) {
        Course saved_course = courseRepository.findCourseById(id);

        if(saved_course == null) {
            throw new ApiException("course not found.");
        }

        saved_course.setName(course.getName());

        courseRepository.save(saved_course);

        return course;
    }

    public Course delete(Integer id) {
        Course course = courseRepository.findCourseById(id);

        if(course == null) {
            throw new ApiException("course not found.");
        }

        courseRepository.deleteById(id);

        return course;
    }

    public Teacher assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if(teacher == null) {
            throw new ApiException("teacher not found.");
        }

        Course course = courseRepository.findCourseById(courseId);

        if(course == null) {
            throw new ApiException("course not found.");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);

        return teacher;
    }
}
