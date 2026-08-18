package services;

import entities.HeadTeacher;
import entities.Teacher;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;

public class TeacherService
        implements Manageable<Teacher>, Searchable<Teacher> {

    private List<Teacher> teachers = new ArrayList<>();


    // Manageable Methods _______________________________________

    @Override
    public void add(Teacher teacher) {

        if (teacher == null) {
            System.out.println("Teacher cannot be null.");
            return;
        }

        teachers.add(teacher);
    }


    @Override
    public boolean remove(String id) {

        Teacher teacher = searchById(id);

        if (teacher != null) {
            teachers.remove(teacher);
            return true;
        }

        return false;
    }


    @Override
    public List<Teacher> getAll() {
        return teachers;
    }


    // Searchable Methods _______________________________________

    @Override
    public Teacher searchById(String id) {

        for (Teacher teacher : teachers) {

            if (teacher.getId().equalsIgnoreCase(id)) {
                return teacher;
            }
        }

        return null;
    }


    @Override
    public List<Teacher> search(String keyword) {

        List<Teacher> result = new ArrayList<>();

        for (Teacher teacher : teachers) {

            if (
                    teacher.getFirstName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || teacher.getLastName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || teacher.getSubject()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())
            ) {

                result.add(teacher);
            }
        }

        return result;
    }


    // Add Head Teacher _________________________________________

    public void addHeadTeacher(HeadTeacher headTeacher) {

        if (headTeacher == null) {
            System.out.println("Head teacher cannot be null.");
            return;
        }

        teachers.add(headTeacher);
    }


    // Assign Class ______________________________________________

    public boolean assignClass(
            String teacherId,
            String className) {

        Teacher teacher = searchById(teacherId);

        if (teacher == null) {
            return false;
        }

        teacher.addClass(className);

        return true;
    }


    // List Teachers By Subject _________________________________

    public List<Teacher> listBySubject(String subject) {

        List<Teacher> result = new ArrayList<>();

        for (Teacher teacher : teachers) {

            if (teacher.getSubject()
                    .equalsIgnoreCase(subject)) {

                result.add(teacher);
            }
        }

        return result;
    }


    // Available Teachers _______________________________________

    public List<Teacher> availableTeachers() {

        List<Teacher> result = new ArrayList<>();

        for (Teacher teacher : teachers) {

            if (teacher.getClassesTaught().isEmpty()) {
                result.add(teacher);
            }
        }

        return result;
    }


    // Count _________________________________________________

    public int getTeacherCount() {
        return teachers.size();
    }
}