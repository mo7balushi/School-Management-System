package entities;

public class SeniorStudent extends Student {

    private String major;
    private double gpa;

    public SeniorStudent(
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
            double feeBalance,
            String major,
            double gpa) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                gradeLevel,
                enrollmentDate,
                feeBalance
        );

        setMajor(major);
        setGpa(gpa);
    }


    // Getters

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }


    // Setters

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {

        if (gpa < 0 || gpa > 4.0) {
            System.out.println("GPA must be between 0 and 4.");
            return;
        }

        this.gpa = gpa;
    }


    // Overriding

    @Override
    public void displayInfo() {

        System.out.println(
                "Senior Student: "
                        + getFullName()
                        + " | Grade: "
                        + getGradeLevel()
                        + " | Major: "
                        + getMajor()
                        + " | GPA: "
                        + getGpa()
        );
    }


    @Override
    public String displaySummary() {

        return getId()
                + " - "
                + getFullName()
                + " - "
                + getMajor();
    }
}