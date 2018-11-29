package ua.kiev.prog.homework4;

import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Group implements Serializable {
    private Student[] students = new Student[10];

    public void add(Student student) {
        boolean added = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                added = true;
                break;
            }
        }
        if (!added) throw new StudentOperationException(student);
    }

    public void delete(String lastName) {
        students[getIndex(lastName)] = null;
    }

    public int getIndex(String lastName) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] != null && students[i].getLastName().equalsIgnoreCase(lastName)) return i;
        }
        throw new InputMismatchException();
    }

    public Student[] getStudents() {
        return students;
    }

    public void sort(Parameters sortParameters) {
        switch (sortParameters) {
            case FIRSTNAME:
                Arrays.sort(students, (student1, student2) -> {
                    if (student1 != null && student2 != null)
                        return student1.getFirstName().compareToIgnoreCase(student2.getFirstName());
                    else return 1;
                });
                break;
            case LASTNAME:
                Arrays.sort(students, (student1, student2) -> {
                    if (student1 != null && student2 != null)
                        return student1.getLastName().compareToIgnoreCase(student2.getLastName());
                    else return 1;
                });
                break;
            case AGE:
                Arrays.sort(students, (student1, student2) -> {
                    if (student1 != null && student2 != null)
                        return student1.getAge() - student2.getAge();
                    else return 1;
                });
                break;
            case SEX:
                Arrays.sort(students, (student1, student2) -> {
                    if (student1 != null && student2 != null) {
                        if (student1.getSex() == student2.getSex()) return 0;
                        if (student1.getSex() == Sex.MALE) return -1;
                        else return 1;
                    } else return 1;
                });
                break;
            case PERFORMANCE:
                Arrays.sort(students, (student1, student2) -> {
                    if (student1 != null && student2 != null)
                        return student1.getPerformance() - student2.getPerformance();
                    else return 1;
                });
        }
    }

    @Override
    public String toString() {
        String formattedStudents = "";
        for (Student student : students) {
            formattedStudents += student + "\n";
        }
        return formattedStudents;
    }
}
