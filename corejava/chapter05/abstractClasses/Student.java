package chapter05.abstractClasses;

public class Student extends Person {
    private String major;

    /**
     * @param n student's name
     * @param m student's major
     */
    public Student(String n, String m) {
        //pass n to superclass constructor
        super(n);
        this.major = m;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
