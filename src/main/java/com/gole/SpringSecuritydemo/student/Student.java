package com.gole.SpringSecuritydemo.student;

public class Student {

    private final Integer sId;
    private final String studentName;


    public Student(Integer sId, String studentName) {
        this.sId = sId;
        this.studentName = studentName;
    }

    public Integer getsId() {
        return sId;
    }

    public String getStudentName() {
        return studentName;
    }
}
