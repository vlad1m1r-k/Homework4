package ua.kiev.prog.homework4;

public class Student extends Human {
    private  int performance;

    public Student(String firstName, String lastName, int age, Sex sex, int performance) {
        super(firstName, lastName, age, sex);
        this.performance = performance;
    }

    public int getPerformance() {
        return performance;
    }

    @Override
    public String toString(){
        return super.toString() + " Performance: " + performance;
    }
}
