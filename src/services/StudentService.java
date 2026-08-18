package services;

import entities.Student;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;

public class StudentService
        implements Manageable<Student>, Searchable<Student> {

    private List<Student> students = new ArrayList<>();


    // Manageable Methods _______________________________________

    @Override
    public void add(Student entity) {
        students.add(entity);
    }

    @Override
    public boolean remove(String id) {

        Student student = searchById(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }


    // Searchable Methods _______________________________________

    @Override
    public List<Student> search(String keyword) {

        List<Student> result = new ArrayList<>();

        for (Student student : students) {

            if (
                    student.getFirstName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || student.getLastName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || student.getId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())
            ) {

                result.add(student);
            }
        }

        return result;
    }

    @Override
    public Student searchById(String id) {

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }


    // Overloaded addStudent Methods _____________________________

    public void addStudent(
            String firstName,
            String lastName,
            String phoneNumber) {

        Student student = new Student(
                "S" + (students.size() + 1),
                firstName,
                lastName,
                "N/A",
                "Unknown",
                phoneNumber,
                "unknown@school.com",
                "N/A",
                "Unknown",
                "N/A",
                0
        );

        students.add(student);
    }


    public void addStudent(
            String firstName,
            String lastName,
            String phoneNumber,
            String gradeLevel) {

        Student student = new Student(
                "S" + (students.size() + 1),
                firstName,
                lastName,
                "N/A",
                "Unknown",
                phoneNumber,
                "unknown@school.com",
                "N/A",
                gradeLevel,
                "N/A",
                0
        );

        students.add(student);
    }


    public void addStudent(Student student) {

        if (student != null) {
            students.add(student);
        }
    }
}