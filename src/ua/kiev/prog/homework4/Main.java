package ua.kiev.prog.homework4;

import java.util.Scanner;

public class Main {
    private static Group group;

    public static void main(String[] args) {
        group = new Group();
        try {
            group.add(new Student("Ivan", "Karko", 18, Sex.MALE, 90));
            group.add(new Student("Lena", "Baskova", 19, Sex.FEMALE, 60));
            group.add(new Student("Petr", "Azirov", 18, Sex.MALE, 70));
            group.add(new Student("Petr", "Karko", 18, Sex.MALE, 55));
            group.add(new Student("Petr", "Ali", 18, Sex.MALE, 79));
            group.add(new Student("Inna", "Torba", 18, Sex.FEMALE, 100));
            group.add(new Student("Petr", "Kent", 19, Sex.MALE, 100));
            group.add(new Student("Tom", "Star", 17, Sex.MALE, 30));
            group.add(new Student("Yas", "Torba", 18, Sex.MALE, 45));
        } catch (StudentOperationException soe) {
            System.out.println("Error adding " + soe.getObject().toString());
            System.out.println("Cause " + soe.getMessage());
        }
        Scanner keyboardScanner = new Scanner(System.in);
        String choose = "";
        do {
            System.out.println("1 - Add Student, 2 - Sort, 3 - Print, 4 - Delete, 5 - Summon Voenkom, 0 - Exit");
            System.out.print(">");
            choose = keyboardScanner.next();
            switch (choose) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    sortStudents();
                    break;
                case "3":
                    printStudents();
                    break;
                case "4":
                    deleteStudent();
                    break;
                case "5":
                    summonVoenkom();
                    break;
            }
        } while (!choose.equals("0"));
    }

    private static void addStudent() {
        System.out.println("Adding...");
    }

    private static void sortStudents() {
        System.out.println("Sorting...");
    }

    private static void printStudents() {
        System.out.println(group);
    }

    private static void deleteStudent() {
    }

    private static void summonVoenkom() {
        System.out.println("Summonning...");
    }
}
