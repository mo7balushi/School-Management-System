package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String gradeLevel;
    private String enrollmentDate;
    private double feeBalance;
    private List<String> subjects;


    // Constructor ______________________________________________

    public Student(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String gradeLevel,
            String enrollmentDate,
            double feeBalance) {

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

        this.gradeLevel = gradeLevel;
        this.enrollmentDate = enrollmentDate;

        setFeeBalance(feeBalance);

        subjects = new ArrayList<>();
    }


    // Getters _________________________________________________

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public double getFeeBalance() {
        return feeBalance;
    }

    public List<String> getSubjects() {
        return subjects;
    }


    // Setters _________________________________________________

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setFeeBalance(double feeBalance) {

        if (feeBalance < 0) {
            System.out.println(
                    "Fee cannot be below 0. Keeping it at 0."
            );

            this.feeBalance = 0;
            return;
        }

        this.feeBalance = feeBalance;
    }


    // Subject Functions _______________________________________

    public void addSubject(String subject) {
        subjects.add(subject);
    }


    // Overloading ______________________________________________

    public void updateContact(String phone) {
        setPhoneNumber(phone);
    }

    public void updateContact(
            String phone,
            String email) {

        setPhoneNumber(phone);
        setEmail(email);
    }


    // Overriding _______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Student: "
                        + getFirstName()
                        + " "
                        + getLastName()
                        + " | grade: "
                        + gradeLevel
                        + " | fee balance: "
                        + feeBalance
        );
    }
}