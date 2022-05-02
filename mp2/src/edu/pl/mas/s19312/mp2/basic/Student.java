package edu.pl.mas.s19312.mp2.basic;

import java.time.LocalDateTime;

public class Student {
    private int idStudent;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private Group group;

    public Student(int idStudent, String firstName, String lastName, LocalDateTime dateOfBirth) {
        setIdStudent(idStudent);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().equals("")){
            throw new RuntimeException("firstName cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().equals("")){
            throw new RuntimeException("lastName cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        if(dateOfBirth == null){
            throw new RuntimeException("lastName cannot be null or empty");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        if (group == null){
            throw new RuntimeException("Group cannot be null");
        }
        if(this.group != group && this.group != null){
            removeGroup();
        }
        if(this.group == group){
            return;
        }
        this.group = group;
        group.addStudent(this);
    }

    public void removeGroup(){
        if(this.group == null){
            return;
        }
        Group tmp = this.group;
        this.group = null;
        tmp.removeStudent(this);
    }
}
