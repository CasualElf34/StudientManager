package com.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseByCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Object getCourseById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseById'");
    }
}