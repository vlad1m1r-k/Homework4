package ua.kiev.prog.homework4;

import java.util.InputMismatchException;

public class Group {
    private Student[] students = new Student[10];

    public void add(Student student){
        boolean added = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                added = true;
                break;
            }
        }
        if (!added) throw new StudentOperationException(student);
    }

    public void delete(String lastName){
        students[getIndex(lastName)] = null;
    }

    public int getIndex(String lastName){
        for (int i = 0; i < students.length -1; i++) {
            if (students[i] != null && students[i].getLastName().equalsIgnoreCase(lastName)) return i;
        }
        throw new InputMismatchException();
    }

    @Override
    public String toString(){
        /*ua.kiev.prog.homework4.Student[] sortedStudents = students;
        String formattedStudents = "";
        Arrays.sort(students, new Comparator<ua.kiev.prog.homework4.Student>() {
            @Override
            public int compare(ua.kiev.prog.homework4.Student student1, ua.kiev.prog.homework4.Student student2) {
                if (student1 != null && student2 != null)
                    return student1.getLastName().compareToIgnoreCase(student2.getLastName());
                else return 1;
            }
        });
        for (ua.kiev.prog.homework4.Student student: sortedStudents) {
            formattedStudents += student + "\n";
        }
        return formattedStudents;*/
        String formattedStudents = "";
        for (Student student: students) {
            formattedStudents += student + "\n";
        }
        return formattedStudents;
    }
}
