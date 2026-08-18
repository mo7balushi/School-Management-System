package entities;

public class SeniorStudent extends Student {

    private String specialization;

    public SeniorStudent(
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
            String gradeLevel,
            String enrollmentDate,
            double feeBalance,
            boolean scholarship,
            String specialization) {

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
                active,
                gradeLevel,
                enrollmentDate,
                feeBalance,
                scholarship
        );

        setSpecialization(specialization);
    }

    // Setter

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            System.out.println("Specialization cannot be empty.");
            return;
        }

        this.specialization = specialization;
    }

    // Getter

    public String getSpecialization() {
        return specialization;
    }

    // Overriding

    @Override
    public void displayInfo() {
        System.out.println(
                "Senior Student: " + getFullName() +
                        ", ID: " + getId() +
                        ", Grade Level: " + getGradeLevel() +
                        ", Enrollment Date: " + getEnrollmentDate() +
                        ", Fee Balance: " + getFeeBalance() +
                        ", Scholarship: " + isScholarship() +
                        ", Specialization: " + getSpecialization()
        );
    }

    @Override
    public String displaySummary() {
        return getId() + " - " + getFullName()
                + " - " + getGradeLevel()
                + " - " + getSpecialization();
    }
}