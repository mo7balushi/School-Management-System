package entities;

public class HeadTeacher extends Teacher {

    private String department;
    private int teachersManaged;

    public HeadTeacher(
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
            double salary,
            String department,
            int teachersManaged) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                subject,
                experienceYears,
                salary
        );

        setDepartment(department);
        setTeachersManaged(teachersManaged);
    }

    // Getters

    public String getDepartment() {
        return department;
    }

    public int getTeachersManaged() {
        return teachersManaged;
    }

    // Setters

    public void setDepartment(String department) {

        if (department == null || department.trim().isEmpty()) {
            System.out.println("Department cannot be empty.");
            return;
        }

        this.department = department;
    }

    public void setTeachersManaged(int teachersManaged) {

        if (teachersManaged < 0) {
            System.out.println("Teachers managed cannot be negative.");
            return;
        }

        this.teachersManaged = teachersManaged;
    }

    // Overriding

    @Override
    public void displayInfo() {

        System.out.println(
                "Head Teacher: "
                        + getFullName()
                        + " | Subject: "
                        + getSubject()
                        + " | Department: "
                        + getDepartment()
                        + " | Teachers Managed: "
                        + getTeachersManaged()
        );
    }

    @Override
    public String displaySummary() {

        return getId()
                + " - "
                + getFullName()
                + " - "
                + getDepartment();
    }
}