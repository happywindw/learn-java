package chapter04;

import java.util.*;

/**
 * This program demonstrates object construction.
 */
public class ConstructorTest {
    public static void main(String[] args) {
        //fill the staff array with three Employee3 objects
        Employee3[] staff = new Employee3[3];

        staff[0] = new Employee3("Harry", 70000);
        staff[1] = new Employee3(60000);
        staff[2] = new Employee3();

        //print out information about all Employee objects
        for(Employee3 e: staff)
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
    }
}

class Employee3 {
    private static int nextId;

    private int id;
    private String name = "";  //instance field initialization
    private double salary;

    //static initialization block
    static {
        Random generator = new Random();
        //set nextId  to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    //object initialization block
    {
        id = nextId;
        nextId++;
    }

    //three overloaded constructors
    public Employee3(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee3(double s) {
        //call the Employee3(String n, double s) constructor
        this("Employee #" + nextId, s);
    }

    //the default constructor
    public Employee3() {
        //name initialized to ""--see blow
        //salary not explicitly set--initialized to 0
        //id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
