package com.microservice.course.service;

import com.microservice.course.client.IStudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.percistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private IStudentClient iStudentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        // query the course
        Course course = iCourseRepository.findById(idCourse).orElse(new Course());

        // get the students
        List<StudentDTO> studentDTOList = iStudentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();

    }
}
