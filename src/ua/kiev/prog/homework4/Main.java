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
            group.add(new Student("Yas", "Barto", 19, Sex.MALE, 45));
        } catch (StudentOperationException soe) {
            System.out.println("Error adding " + soe.getObject().toString());
            System.out.println("Cause " + soe.getMessage());
        }
        Scanner keyboardScanner = new Scanner(System.in);
        String choose = "";
        do {
            System.out.println("1 - Add Student, 2 - Sort, 3 - Print, 4 - Delete, 5 - Summon Voenkom, 0 - Exit");
            System.out.print(">");
            choose = keyboardScanner.nextLine();
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
        if (!args[3].equalsIgnoreCase("M") && !args[3].equalsIgnoreCase("F")) {
            System.out.println("Sex accepts only M or F symbols. " + args[3]);
            return;
        }
        Sex sex = args[3].equalsIgnoreCase("M") ? Sex.MALE : Sex.FEMALE;
        if (!args[4].matches("\\d+")) {
            System.out.println("Error parsing AcademicPerformance: " + args[2]);
            return;
        }
        int academPerform = Integer.parseInt(args[4]);
        if (academPerform < 0 || academPerform > 100) {
            System.out.println("AcademicPerformance is out of range (0 - 100)");
            return;
        }
        try {
            group.add(new Student(args[0], args[1], age, sex, academPerform));
        } catch (StudentOperationException soe) {
            System.out.println("Can not add more students.");
        }
    }

    private static void sortStudents() {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Sort by: \n1 - FirstName \n2 - LastName \n3 - Age \n4 - Sex \n5 - AcademicPerformance\n>");
        String choose = keyboardScanner.nextLine();
        switch (choose) {
            case "1":
                group.sort(Parameters.FIRSTNAME);
                break;
            case "2":
                group.sort(Parameters.LASTNAME);
                break;
            case "3":
                group.sort(Parameters.AGE);
                break;
            case "4":
                group.sort(Parameters.SEX);
                break;
            case "5":
                group.sort(Parameters.PERFORMANCE);
                break;
        }
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
        AngryVoenkom angryVoenkom = new AngryVoenkom();
        Student[] students = angryVoenkom.catchStudents(group);
        String formattedStudents = "";
        for (Student student : students) {
            if (student != null) formattedStudents += student + "\n";
        }
        System.out.println("Catched students:");
        System.out.println(formattedStudents);
    }
}
