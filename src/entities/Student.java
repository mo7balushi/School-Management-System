package entities;

public class Student extends Person {

    private String gradeLevel;
    private String enrollmentDate;

    private String[] enrolledSubjects;
    private String[] pastCourseRecordIds;

    private int subjectCount;
    private int recordCount;

    private double feeBalance;
    private boolean scholarship;


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
            String nationalId,
            int age,
            boolean active,
            String gradeLevel,
            String enrollmentDate,
            double feeBalance,
            boolean scholarship) {

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

        setGradeLevel(gradeLevel);
        setEnrollmentDate(enrollmentDate);
        setFeeBalance(feeBalance);
        setScholarship(scholarship);

        enrolledSubjects = new String[10];
        pastCourseRecordIds = new String[20];

        subjectCount = 0;
        recordCount = 0;
    }


    // Setters _________________________________________________

    public void setGradeLevel(String gradeLevel) {
        if (gradeLevel == null || gradeLevel.trim().isEmpty()) {
            System.out.println("Grade level cannot be empty.");
            return;
        }

        this.gradeLevel = gradeLevel;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        if (enrollmentDate == null || enrollmentDate.trim().isEmpty()) {
            System.out.println("Enrollment date cannot be empty.");
            return;
        }

        this.enrollmentDate = enrollmentDate;
    }

    public void setFeeBalance(double feeBalance) {
        if (feeBalance < 0) {
            System.out.println("Fee balance cannot be negative.");
            return;
        }

        this.feeBalance = feeBalance;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
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

    public boolean isScholarship() {
        return scholarship;
    }

    public int getSubjectCount() {
        return subjectCount;
    }

    public int getRecordCount() {
        return recordCount;
    }


    // Subject Functions _______________________________________

    public void addSubject(String subject) {

        if (subject == null || subject.trim().isEmpty()) {
            System.out.println("Subject cannot be empty.");
            return;
        }

        if (hasSubject(subject)) {
            System.out.println("Student already has this subject.");
            return;
        }

        if (subjectCount >= enrolledSubjects.length) {
            System.out.println("Subject list is full.");
            return;
        }

        enrolledSubjects[subjectCount] = subject;
        subjectCount++;
    }


    public boolean hasSubject(String subject) {

        for (int i = 0; i < subjectCount; i++) {

            if (enrolledSubjects[i].equalsIgnoreCase(subject)) {
                return true;
            }
        }

        return false;
    }


    public void listSubjects() {

        if (subjectCount == 0) {
            System.out.println("No subjects enrolled.");
            return;
        }

        for (int i = 0; i < subjectCount; i++) {
            System.out.println(enrolledSubjects[i]);
        }
    }


    // Course Record Functions _________________________________

    public void addRecordId(String recordId) {

        if (recordId == null || recordId.trim().isEmpty()) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        if (recordCount >= pastCourseRecordIds.length) {
            System.out.println("Course record list is full.");
            return;
        }

        pastCourseRecordIds[recordCount] = recordId;
        recordCount++;
    }


    // Fee Functions ___________________________________________

    public void addToBalance(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        feeBalance += amount;
    }


    public void clearBalance() {
        feeBalance = 0;
    }


    // Overriding ______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Student: " + getFullName() +
                        ", ID: " + getId() +
                        ", Grade Level: " + getGradeLevel() +
                        ", Enrollment Date: " + getEnrollmentDate() +
                        ", Fee Balance: " + getFeeBalance() +
                        ", Scholarship: " + isScholarship()
        );
    }


    @Override
    public String displaySummary() {

        return getId()
                + " - "
                + getFullName()
                + " - Grade: "
                + getGradeLevel();
    }
}