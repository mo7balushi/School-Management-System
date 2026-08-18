package entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private String subject;
    private int experienceYears;
    private double salary;
    private List<String> classesTaught;


    // Constructor ______________________________________________

    public Teacher(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String subject,
            int experienceYears,
            double salary) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address
        );

        this.subject = subject;
        setExperienceYears(experienceYears);
        setSalary(salary);

        classesTaught = new ArrayList<>();
    }


    // Getters _________________________________________________

    public String getSubject() {
        return subject;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getClassesTaught() {
        return classesTaught;
    }


    // Setters _________________________________________________

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {
            System.out.println("Experience cannot be negative.");
            return;
        }

        this.experienceYears = experienceYears;
    }

    public void setSalary(double salary) {

        if (salary < 0) {
            System.out.println("Salary cannot be negative.");
            return;
        }

        this.salary = salary;
    }


    // Class Functions __________________________________________

    public void addClass(String className) {

        if (className == null || className.trim().isEmpty()) {
            System.out.println("Class cannot be empty.");
            return;
        }

        classesTaught.add(className);
    }


    // Overloading ______________________________________________

    public void updateSalary(double salary) {
        setSalary(salary);
    }

    public void updateSalary(
            double salary,
            String reason) {

        setSalary(salary);

        System.out.println(
                "Salary updated. Reason: " + reason
        );
    }


    // Overriding _______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Teacher: "
                        + getFullName()
                        + " | Subject: "
                        + getSubject()
                        + " | Experience: "
                        + getExperienceYears()
                        + " years"
                        + " | Salary: "
                        + getSalary()
        );
    }


    @Override
    public String displaySummary() {

        return getId()
                + " - "
                + getFullName()
                + " - "
                + getSubject();
    }
}