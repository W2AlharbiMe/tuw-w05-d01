package com.example.homeworkweek05d1.Repository;

import com.example.homeworkweek05d1.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);


}
