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
            String grade,
            double feeBalance,
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
                grade,
                feeBalance
        );

        setSpecialization(specialization);
    }
    //Setter---------------------------------------------
    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            System.out.println("Specialization cannot be empty.");
            return;
        }

        this.specialization = specialization;
    }
    //Getter_________________________________________________
    public String getSpecialization() {
        return specialization;
    }

    //Function
    @Override
    public void displayInfo() {
        System.out.println(
                "Senior Student: " + getFirstName() + " " + getLastName() +
                        ", Grade: " + getGrade() +
                        ", Fee Balance: " + getFeeBalance() +
                        ", Specialization: " + getSpecialization()
        );
    }

}
