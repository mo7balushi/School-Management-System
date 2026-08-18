package services;

import entities.Student;
import utils.HelperUtils;
import utils.InputHandler;

public class MenuService {

    private StudentService studentService = new StudentService();

    public void start() {

        boolean exit = false;

        while (!exit) {

            System.out.println("==============================");
            System.out.println("   SCHOOL MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            int choice = InputHandler.readInt("Choose option: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudentById();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }


    // Add Student ______________________________________________

    private void addStudent() {

        String id =
                InputHandler.readString("Enter ID: ");

        if (!HelperUtils.isValidString(id)) {
            System.out.println("Invalid ID.");
            return;
        }

        if (studentService.searchById(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }


        String firstName =
                InputHandler.readString("Enter first name: ");

        if (!HelperUtils.isValidString(firstName, 2)) {
            System.out.println("Invalid first name.");
            return;
        }


        String lastName =
                InputHandler.readString("Enter last name: ");

        if (!HelperUtils.isValidString(lastName, 2)) {
            System.out.println("Invalid last name.");
            return;
        }


        String dateOfBirth =
                InputHandler.readString("Enter date of birth: ");

        if (!HelperUtils.isValidString(dateOfBirth)) {
            System.out.println("Invalid date of birth.");
            return;
        }


        String gender =
                InputHandler.readString("Enter gender: ");

        if (!HelperUtils.isValidString(gender)) {
            System.out.println("Invalid gender.");
            return;
        }


        String phoneNumber =
                InputHandler.readString("Enter phone number: ");

        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Phone must contain numbers only.");
            return;
        }


        String email =
                InputHandler.readString("Enter email: ");

        if (!email.contains("@")) {
            System.out.println("Invalid email.");
            return;
        }


        String address =
                InputHandler.readString("Enter address: ");

        if (!HelperUtils.isValidString(address)) {
            System.out.println("Invalid address.");
            return;
        }


        String gradeLevel =
                InputHandler.readString("Enter grade level: ");

        if (!HelperUtils.isValidString(gradeLevel)) {
            System.out.println("Invalid grade level.");
            return;
        }


        String enrollmentDate =
                InputHandler.readString("Enter enrollment date: ");

        if (!HelperUtils.isValidString(enrollmentDate)) {
            System.out.println("Invalid enrollment date.");
            return;
        }


        double feeBalance =
                InputHandler.readDouble("Enter fee balance: ");

        if (feeBalance < 0) {
            System.out.println("Fee balance cannot be negative.");
            return;
        }


        Student student = new Student(
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

        studentService.add(student);

        System.out.println("Student added successfully.");
    }


    // View All Students ________________________________________

    private void viewAllStudents() {

        if (studentService.getAll().isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : studentService.getAll()) {
            student.displayInfo();
        }
    }


    // Search Student ___________________________________________

    private void searchStudentById() {

        String id =
                InputHandler.readString("Enter student ID: ");

        Student student =
                studentService.searchById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayInfo();
    }


    // Remove Student ___________________________________________

    private void removeStudent() {

        String id =
                InputHandler.readString(
                        "Enter student ID to remove: "
                );

        boolean removed =
                studentService.remove(id);

        if (removed) {

            System.out.println(
                    "Student removed successfully."
            );

        } else {

            System.out.println(
                    "Student not found."
            );
        }
    }
}