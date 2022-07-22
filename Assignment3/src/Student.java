public class Student {
    double average;
    String name;

    public boolean average(double ex1, double ex2, double ex3) {
        this.average = (ex1+ex2+ex3)/3;
        return this.average > 50.0;
    }
    public String input(String inputName) {
        this.name = inputName;
        return this.name;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Passing: " + s1.average(50.0, 32.3, 40.0));
        System.out.println("Name: " + s1.input("Dylan"));
        System.out.println("Passing: " + s1.average(90.0,100.0,70.0));
    }
}
