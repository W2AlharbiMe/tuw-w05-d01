package com.example.homeworkweek05d1.Service;

import com.example.homeworkweek05d1.Api.ApiException;
import com.example.homeworkweek05d1.Model.Address;
import com.example.homeworkweek05d1.Model.Course;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Repository.AddressRepository;
import com.example.homeworkweek05d1.Repository.TeacherRepository;
import com.example.homeworkweek05d1.DTO.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;


    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if(teacher == null) {
            throw new ApiException("teacher not found");
        }

        return teacher;
    }

    public Teacher add(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher(null, teacherDTO.getName(), teacherDTO.getAge(), teacherDTO.getEmail(), teacherDTO.getSalary(), null, null);

        return teacherRepository.save(teacher);
    }

    public Teacher update(Integer id, TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findTeacherById(id);


        if(teacher == null) {
            throw new ApiException("teacher not found");
        }

        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setSalary(teacherDTO.getSalary());
        teacher.setEmail(teacherDTO.getEmail());

        teacherRepository.save(teacher);

        return teacher;
    }


    public Teacher delete(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);


        if(teacher == null) {
            throw new ApiException("teacher not found");
        }

        if(teacher.getAddress() != null) {
            addressRepository.deleteById(id);
        }

        teacherRepository.deleteById(id);

        return teacher;
    }

}
