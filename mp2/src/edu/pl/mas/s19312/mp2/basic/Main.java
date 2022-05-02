package edu.pl.mas.s19312.mp2.basic;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student(1, "John", "Smith", LocalDateTime.now());
        Student student2 = new Student(2, "Jan", "Kowak", LocalDateTime.now());
        Student student3 = new Student(3, "Max", "Kowalski", LocalDateTime.now());

        //create and assign student1 to group1
        Group group1 = new Group("15a",student1);
        System.out.println("Size of group1: " + group1.getStudents().size());

        //assign student2 to group1
        group1.addStudent(student2);
        System.out.println("Size of group1: " + group1.getStudents().size());

        //assign student3 to group1
        student3.setGroup(group1);
        System.out.println("Size of group1: " + group1.getStudents().size());

        //remove student3 from group1
        student3.removeGroup();
        System.out.println("After removing group1 for student3:\n\tStudent3 assign to group: " + student3.getGroup());
        System.out.println("\tSize of group1: " + group1.getStudents().size());
        System.out.println("\tgroup1 contains Student3: " + group1.getStudents().contains(student3));

        //remove student2 from group1
        group1.removeStudent(student2);
        System.out.println("After removing group1 for student2:\n\tStudent2 assign to group: " + student2.getGroup());
        System.out.println("\tSize of group1: " + group1.getStudents().size());
        System.out.println("\tgroup1 contains Student2: " + group1.getStudents().contains(student2));

        group1.addStudent(student2);
        System.out.println("Size of group1: " + group1.getStudents().size());

        //reassign Student2 from group 1 to group2
        Group group2 = new Group("14f",student2);
        System.out.println("After moving student2 from group1 to group2:\n\tStudent2 assign to idGroup: " + student2.getGroup().getIdGroup());
        System.out.println("\tSize of group1: " + group1.getStudents().size());
        System.out.println("\tgroup1 contains Student2: " + group1.getStudents().contains(student2));
        System.out.println("\tgroup2 contains Student2: " + group2.getStudents().contains(student2));


    }
}
