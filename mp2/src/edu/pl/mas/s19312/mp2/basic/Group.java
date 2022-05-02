package edu.pl.mas.s19312.mp2.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private String idGroup;
    private List<Student> students = new ArrayList<>();

    public Group(String idGroup, Student student) {
        setIdGroup(idGroup);
        addStudent(student);
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        if(idGroup == null || idGroup.trim().equals("")){
            throw new RuntimeException("idGroup cannot be null or empty");
        }
        this.idGroup = idGroup;
    }

    public List<Student> getStudents() {
        List<Student> tmp = this.students;
        return tmp;
    }

    public void addStudent(Student student) {
        if(student == null){
            throw new RuntimeException("Student cannot be null");
        }
        if(!students.contains(student)){
            if(students.size() > 15){
                throw new RuntimeException("Group is full! Max number of students for one group is 16");
            }
            students.add(student);
            student.setGroup(this);
        }
    }

    public void removeStudent(Student student) {
        if(student == null){
            throw new RuntimeException("Student cannot be null");
        }
        if(!students.contains(student)){
            return;
        }
        if(students.size() < 2){
            throw new RuntimeException("Cannot remove last student!");
        }
        students.remove(student);
        student.removeGroup();
    }
}
