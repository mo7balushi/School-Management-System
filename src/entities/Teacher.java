package entities;

public class Teacher extends Person {

    private String subject;
    private int experienceYears;
    private double salary;

    private String[] availableSlots;
    private String[] assignedClassIds;

    private int slotCount;
    private int classCount;

    private boolean formTeacher;


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
            String nationalId,
            int age,
            boolean active,
            String subject,
            int experienceYears,
            double salary,
            boolean formTeacher) {

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
        setExperienceYears(experienceYears);
        setSalary(salary);
        setFormTeacher(formTeacher);

        availableSlots = new String[20];
        assignedClassIds = new String[20];

        slotCount = 0;
        classCount = 0;
    }


    // Setters _________________________________________________

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            System.out.println("Subject cannot be empty.");
            return;
        }

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

    public void setFormTeacher(boolean formTeacher) {
        this.formTeacher = formTeacher;
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

    public boolean isFormTeacher() {
        return formTeacher;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public int getClassLoad() {
        return classCount;
    }


    // Slot Methods _____________________________________________

    public void addSlot(String slot) {

        if (slot == null || slot.trim().isEmpty()) {
            System.out.println("Slot cannot be empty.");
            return;
        }

        if (hasSlot(slot)) {
            System.out.println("Slot already exists.");
            return;
        }

        if (slotCount >= availableSlots.length) {
            System.out.println("Slot list is full.");
            return;
        }

        availableSlots[slotCount] = slot;
        slotCount++;
    }


    public boolean hasSlot(String slot) {

        for (int i = 0; i < slotCount; i++) {

            if (availableSlots[i].equalsIgnoreCase(slot)) {
                return true;
            }
        }

        return false;
    }


    public void removeSlot(String slot) {

        for (int i = 0; i < slotCount; i++) {

            if (availableSlots[i].equalsIgnoreCase(slot)) {

                for (int j = i; j < slotCount - 1; j++) {
                    availableSlots[j] = availableSlots[j + 1];
                }

                availableSlots[slotCount - 1] = null;
                slotCount--;

                return;
            }
        }

        System.out.println("Slot not found.");
    }


    // Class Assignment _________________________________________

    public void assignClass(String classId) {

        if (classId == null || classId.trim().isEmpty()) {
            System.out.println("Class ID cannot be empty.");
            return;
        }

        if (classCount >= assignedClassIds.length) {
            System.out.println("Class list is full.");
            return;
        }

        assignedClassIds[classCount] = classId;
        classCount++;
    }


    // Salary Methods ___________________________________________

    public void raiseSalary(double amount) {

        if (amount <= 0) {
            System.out.println("Salary increase must be greater than zero.");
            return;
        }

        setSalary(salary + amount);
    }


    // Overloading required later in Task 2.2

    public void updateSalary(double salary) {
        setSalary(salary);
    }

    public void updateSalary(double salary, String reason) {
        setSalary(salary);
        System.out.println("Salary updated. Reason: " + reason);
    }


    // Overriding ______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Teacher: " + getFullName() +
                        ", ID: " + getId() +
                        ", Subject: " + getSubject() +
                        ", Experience: " + getExperienceYears() + " years" +
                        ", Salary: " + getSalary() +
                        ", Form Teacher: " + isFormTeacher() +
                        ", Available Slots: " + getSlotCount() +
                        ", Class Load: " + getClassLoad()
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