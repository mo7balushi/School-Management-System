package entities;

public class Student extends Person {

    private String grade;
    private double feeBalance;

    public Student(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            int age,
            boolean active,
            String grade,
            double feeBalance) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                nationalId,
                age,
                active
        );

        setGrade(grade);
        setFeeBalance(feeBalance);
    }

    // Setters

    public void setGrade(String grade) {
        if (grade == null || grade.trim().isEmpty()) {
            System.out.println("Grade cannot be empty.");
            return;
        }

        this.grade = grade;
    }

    public void setFeeBalance(double feeBalance) {
        if (feeBalance < 0) {
            System.out.println("Fee balance cannot be negative.");
            return;
        }

        this.feeBalance = feeBalance;
    }

    // Getters

    public String getGrade() {
        return grade;
    }

    public double getFeeBalance() {
        return feeBalance;
    }

    // Overloading

    public void updateFee(double amount) {
        setFeeBalance(amount);
    }

    public void updateFee(double amount, String reason) {
        setFeeBalance(amount);
        System.out.println("Reason: " + reason);
    }

    // Overriding

    @Override
    public void displayInfo() {
        System.out.println(
                "Student: " + getFullName() +
                        ", ID: " + getId() +
                        ", Grade: " + getGrade() +
                        ", Fee Balance: " + getFeeBalance()
        );
    }

    @Override
    public String displaySummary() {
        return getId() + " - " + getFullName() + " - Grade: " + getGrade();
    }
}