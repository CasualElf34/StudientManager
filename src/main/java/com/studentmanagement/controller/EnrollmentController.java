package com.studentmanagement.controller;

import com.studentmanagement.model.Student;
import com.studentmanagement.model.Course;
import com.studentmanagement.service.EnrollmentService;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String getEnrollmentsPage(Model model) {
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        return "enrollmentsPage";
    }

    @PostMapping
    public String enrollStudent(@RequestParam Long studentId, @RequestParam String courseCode, Model model) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseByCode(courseCode);
        enrollmentService.enrollStudentInCourse(student, course);
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        return "enrollmentsPage";
    }
}