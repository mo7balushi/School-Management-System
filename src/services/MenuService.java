package services;

import utils.HelperUtils;
import utils.InputHandler;
import entities.Student;

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

    private void addStudent() {

        String id = InputHandler.readString("Enter ID: ");

        if (!HelperUtils.isValidString(id)) {
            System.out.println("Invalid ID.");
            return;
        }

        if (studentService.searchById(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        String firstName = InputHandler.readString("Enter first name: ");

        if (!HelperUtils.isValidString(firstName, 2)) {
            System.out.println("Invalid first name.");
            return;
        }

        String lastName = InputHandler.readString("Enter last name: ");

        if (!HelperUtils.isValidString(lastName, 2)) {
            System.out.println("Invalid last name.");
            return;
        }

        String dateOfBirth =
                InputHandler.readString("Enter date of birth: ");

        String gender =
                InputHandler.readString("Enter gender: ");

        String phoneNumber =
                InputHandler.readString("Enter phone number: ");

        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Phone number must contain numbers only.");
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

        String nationalId =
                InputHandler.readString("Enter national ID: ");

        int age =
                InputHandler.readInt("Enter age: ");

        if (!HelperUtils.isValidAge(age)) {
            System.out.println("Invalid age.");
            return;
        }

        boolean active = true;

        String grade =
                InputHandler.readString("Enter grade: ");

        if (!HelperUtils.isValidString(grade)) {
            System.out.println("Invalid grade.");
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
                nationalId,
                age,
                active,
                grade,
                feeBalance
        );

        studentService.add(student);

        System.out.println("Student added successfully.");
    }
    private void viewAllStudents() {

        if (studentService.getAll().isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : studentService.getAll()) {
            student.displayInfo();
        }
    }
    private void searchStudentById() {

        String id = InputHandler.readString("Enter student ID: ");

        Student student = studentService.searchById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayInfo();
    }
    private void removeStudent() {

        String id = InputHandler.readString("Enter student ID to remove: ");

        boolean removed = studentService.remove(id);

        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }



    }




