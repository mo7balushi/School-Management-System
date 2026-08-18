package entities;

public class Teacher extends Person {
    private String subject;
    private double salary;
    private int yearsOfExperience;
    public Teacher(
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
            String subject,
            int yearsOfExperience,
            double salary) {

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

        setSubject(subject);
        setYearsOfExperience(yearsOfExperience);
        setSalary(salary);
    }

    //Getter______________________________________________________
    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            System.out.println("Subject cannot be empty.");
            return;
        }

        this.subject = subject;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            System.out.println("Experience cannot be negative.");
            return;
        }

        this.yearsOfExperience = yearsOfExperience;
    }


    //Setter____________________________________________________
    public String getSubject() {
        return subject;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    //Function
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be negative.");
            return;
        }

        this.salary = salary;
    }
    public void updateSalary(double salary) {
        setSalary(salary);
    }

    public void updateSalary(double salary, String reason) {
        setSalary(salary);
        System.out.println("Salary updated. Reason: " + reason);
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Teacher: " + getFirstName() + " " + getLastName() +
                        ", Subject: " + getSubject() +
                        ", Experience: " + getYearsOfExperience() + " years" +
                        ", Salary: " + getSalary()
        );
    }

}
