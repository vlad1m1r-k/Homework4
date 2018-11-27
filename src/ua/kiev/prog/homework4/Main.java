package ua.kiev.prog.homework4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Group group;

    public static void main(String[] args) {
        group = new Group();
        try {
            group.add(new Student("Ivan", "Karko", 18, Sex.MALE, 90));
            group.add(new Student("Lena", "Baskova", 19, Sex.FEMALE, 60));
            group.add(new Student("Petr", "Azirov", 18, Sex.MALE, 70));
            group.add(new Student("Uy", "Chang", 18, Sex.FEMALE, 55));
            group.add(new Student("Petr", "Ali", 18, Sex.MALE, 79));
            group.add(new Student("Inna", "Torba", 18, Sex.FEMALE, 100));
            group.add(new Student("Petr", "Kent", 19, Sex.MALE, 100));
            group.add(new Student("Tom", "Star", 17, Sex.MALE, 30));
            group.add(new Student("Yas", "Barto", 18, Sex.MALE, 45));
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
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Enter \nFirstName LastName Age(1-100) Sex(M|F) AcademicPerformance(0-100) \n Separated by space: ");
        String[] args = keyboardScanner.nextLine().split(" +");
        if (args.length != 5) {
            System.out.println("Wrong parameters count. " + args.length);
            return;
        }
        if (!args[2].matches("\\d+")) {
            System.out.println("Error parsing Age: " + args[2]);
            return;
        }
        int age = Integer.parseInt(args[2]);
        if (age < 0) {
            System.out.println("Age can not be negative.");
            return;
        }
        if (!args[3].equalsIgnoreCase("M") || !args[3].equalsIgnoreCase("F")) {
            System.out.println("Sex accepts only M or F symbols. " + args[3]);
            return;
        }
        if (!args[4].matches("\\d+")) {
            System.out.println("Error parsing AcademicPerformance: " + args[2]);
            return;
        }
        int academPerform = Integer.parseInt(args[4]);
        if (academPerform < 0 || academPerform > 100) {
            System.out.println("AcademicPerformance is out of range (0 - 100)");
            return;
        }
    }

    private static void sortStudents() {
        System.out.println("Sorting...");
    }

    private static void printStudents() {
        System.out.println(group);
    }

    private static void deleteStudent() {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Enter student LastName: ");
        try {
            group.delete(keyboardScanner.next());
        } catch (InputMismatchException ime) {
            System.out.println("Error deleting student: Student not found!");
        }
    }

    private static void summonVoenkom() {
        System.out.println("Summonning...");
    }
}
