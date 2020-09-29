package com.gole.SpringSecuritydemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "sandip gole"),
            new Student(2, "Ram hari"),
            new Student(3, "Krishna prasad")
    );

    @GetMapping(path = "{sId}")
    public Student getStudent(@PathVariable("sId") Integer sId)
    {

        return STUDENTS.stream()
                .filter(student -> sId.equals(student.getsId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student " + sId + " does not exists"
                ));

    }

}
