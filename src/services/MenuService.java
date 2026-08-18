package services;

import entities.Student;
import entities.Teacher;
import utils.HelperUtils;
import utils.InputHandler;

public class MenuService {

    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();


    // Main Menu _________________________________________________

    public void start() {

        boolean exit = false;

        while (!exit) {

            System.out.println("\n================================");
            System.out.println("    SCHOOL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Exit");

            int choice =
                    InputHandler.readInt("Choose option: ");

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    teacherMenu();
                    break;

                case 3:
                    exit = true;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    // ============================================================
    // STUDENT MENU
    // ============================================================

    private void studentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n---------- STUDENT MENU ----------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Students by Keyword");
            System.out.println("5. Remove Student");
            System.out.println("6. Back");

            int choice =
                    InputHandler.readInt("Choose option: ");

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
                    searchStudents();
                    break;

                case 5:
                    removeStudent();
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    // Add Student _______________________________________________

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

        String gender =
                InputHandler.readString("Enter gender: ");

        String phoneNumber =
                InputHandler.readString("Enter phone number: ");

        if (!phoneNumber.matches("\\d+")) {
            System.out.println(
                    "Phone must contain numbers only."
            );
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

        String gradeLevel =
                InputHandler.readString("Enter grade level: ");

        String enrollmentDate =
                InputHandler.readString("Enter enrollment date: ");

        double feeBalance =
                InputHandler.readDouble("Enter fee balance: ");

        if (feeBalance < 0) {
            System.out.println(
                    "Fee balance cannot be negative."
            );
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


    // View Students _____________________________________________

    private void viewAllStudents() {

        if (studentService.getAll().isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- ALL STUDENTS ---");

        for (Student student : studentService.getAll()) {
            student.displayInfo();
        }
    }


    // Search Student by ID ______________________________________

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


    // Search Student by Keyword _________________________________

    private void searchStudents() {

        String keyword =
                InputHandler.readString(
                        "Enter name or ID keyword: "
                );

        if (studentService.search(keyword).isEmpty()) {
            System.out.println("No matching students.");
            return;
        }

        for (Student student :
                studentService.search(keyword)) {

            student.displayInfo();
        }
    }


    // Remove Student ____________________________________________

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
            System.out.println("Student not found.");
        }
    }


    // ============================================================
    // TEACHER MENU
    // ============================================================

    private void teacherMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n---------- TEACHER MENU ----------");
            System.out.println("1. Add Teacher");
            System.out.println("2. View All Teachers");
            System.out.println("3. Search Teacher by ID");
            System.out.println("4. Search Teachers by Keyword");
            System.out.println("5. Remove Teacher");
            System.out.println("6. List Teachers by Subject");
            System.out.println("7. Assign Class");
            System.out.println("8. View Available Teachers");
            System.out.println("9. Back");

            int choice =
                    InputHandler.readInt("Choose option: ");

            switch (choice) {

                case 1:
                    addTeacher();
                    break;

                case 2:
                    viewAllTeachers();
                    break;

                case 3:
                    searchTeacherById();
                    break;

                case 4:
                    searchTeachers();
                    break;

                case 5:
                    removeTeacher();
                    break;

                case 6:
                    listTeachersBySubject();
                    break;

                case 7:
                    assignClass();
                    break;

                case 8:
                    viewAvailableTeachers();
                    break;

                case 9:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    // Add Teacher _______________________________________________

    private void addTeacher() {

        String id =
                InputHandler.readString("Enter ID: ");

        if (!HelperUtils.isValidString(id)) {
            System.out.println("Invalid ID.");
            return;
        }

        if (teacherService.searchById(id) != null) {
            System.out.println("Teacher ID already exists.");
            return;
        }

        String firstName =
                InputHandler.readString("Enter first name: ");

        String lastName =
                InputHandler.readString("Enter last name: ");

        String dateOfBirth =
                InputHandler.readString("Enter date of birth: ");

        String gender =
                InputHandler.readString("Enter gender: ");

        String phoneNumber =
                InputHandler.readString("Enter phone number: ");

        if (!phoneNumber.matches("\\d+")) {
            System.out.println(
                    "Phone must contain numbers only."
            );
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

        String subject =
                InputHandler.readString("Enter subject: ");

        int experienceYears =
                InputHandler.readInt(
                        "Enter years of experience: "
                );

        if (experienceYears < 0) {
            System.out.println(
                    "Experience cannot be negative."
            );
            return;
        }

        double salary =
                InputHandler.readDouble("Enter salary: ");

        if (salary < 0) {
            System.out.println(
                    "Salary cannot be negative."
            );
            return;
        }

        Teacher teacher = new Teacher(
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

        teacherService.add(teacher);

        System.out.println("Teacher added successfully.");
    }


    // View Teachers _____________________________________________

    private void viewAllTeachers() {

        if (teacherService.getAll().isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.println("\n--- ALL TEACHERS ---");

        for (Teacher teacher : teacherService.getAll()) {
            teacher.displayInfo();
        }
    }


    // Search Teacher by ID ______________________________________

    private void searchTeacherById() {

        String id =
                InputHandler.readString("Enter teacher ID: ");

        Teacher teacher =
                teacherService.searchById(id);

        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        teacher.displayInfo();
    }


    // Search Teacher ____________________________________________

    private void searchTeachers() {

        String keyword =
                InputHandler.readString(
                        "Enter keyword: "
                );

        if (teacherService.search(keyword).isEmpty()) {
            System.out.println("No matching teachers.");
            return;
        }

        for (Teacher teacher :
                teacherService.search(keyword)) {

            teacher.displayInfo();
        }
    }


    // Remove Teacher ____________________________________________

    private void removeTeacher() {

        String id =
                InputHandler.readString(
                        "Enter teacher ID to remove: "
                );

        boolean removed =
                teacherService.remove(id);

        if (removed) {
            System.out.println(
                    "Teacher removed successfully."
            );
        } else {
            System.out.println("Teacher not found.");
        }
    }


    // List Teachers by Subject __________________________________

    private void listTeachersBySubject() {

        String subject =
                InputHandler.readString(
                        "Enter subject: "
                );

        if (teacherService
                .listBySubject(subject)
                .isEmpty()) {

            System.out.println(
                    "No teachers found for this subject."
            );
            return;
        }

        for (Teacher teacher :
                teacherService.listBySubject(subject)) {

            teacher.displayInfo();
        }
    }


    // Assign Class ______________________________________________

    private void assignClass() {

        String teacherId =
                InputHandler.readString(
                        "Enter teacher ID: "
                );

        String className =
                InputHandler.readString(
                        "Enter class name: "
                );

        boolean assigned =
                teacherService.assignClass(
                        teacherId,
                        className
                );

        if (assigned) {
            System.out.println(
                    "Class assigned successfully."
            );
        } else {
            System.out.println("Teacher not found.");
        }
    }


    // Available Teachers ________________________________________

    private void viewAvailableTeachers() {

        if (teacherService
                .availableTeachers()
                .isEmpty()) {

            System.out.println(
                    "No available teachers."
            );
            return;
        }

        for (Teacher teacher :
                teacherService.availableTeachers()) {

            teacher.displayInfo();
        }
    }
}