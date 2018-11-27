package ua.kiev.prog.homework4;

import java.util.Arrays;

public class AngryVoenkom implements Voenkom {
    @Override
    public Student[] catchStudents(Group group) {
        Student[] catchedStudents = new Student[10];
        int index = 0;
        for (Student student : group.getStudents()) {
            if (student != null && student.getSex() == Sex.MALE && student.getAge() > 18) {
                catchedStudents[index] = student;
                index++;
            }
        }
        return catchedStudents;
    }
}
