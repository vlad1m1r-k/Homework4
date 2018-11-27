package ua.kiev.prog.homework4;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        try {
            group.add(new Student("Ivan", "Karko", 18, Sex.MALE, 90));
            group.add(new Student("Lena", "Baskova", 19, Sex.FEMALE,60));
            group.add(new Student("Petr", "Azirov", 18, Sex.MALE,70));
            group.add(new Student("Petr", "Karko", 18, Sex.MALE,55));
            group.add(new Student("Petr", "Ali", 18, Sex.MALE,79));
            group.add(new Student("Inna", "Torba", 18, Sex.FEMALE,100));
            group.add(new Student("Petr", "Kent", 19, Sex.MALE,100));
            group.add(new Student("Tom", "Star", 17, Sex.MALE,30));
            group.add(new Student("Yas", "Torba", 18, Sex.MALE,45));
            group.add(new Student("Don", "Karko", 19, Sex.MALE,71));
            group.add(new Student("Petr", "Unlucky", 18, Sex.MALE,10));
        } catch (StudentOperationException soe){
            System.out.println("Error adding " + soe.getObject().toString());
            System.out.println("Cause " + soe.getMessage());
        }
        try {
            group.delete("Wonty");
        } catch (InputMismatchException ime){
            System.out.println("ua.kiev.prog.homework4.Student to delete not found!");
        }
        System.out.println(group);
    }
}
