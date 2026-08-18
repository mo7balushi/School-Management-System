package services;

import entities.HeadTeacher;
import entities.Teacher;

public class TeacherService {

    private Teacher[] teachers;
    private int teacherCount;

    public TeacherService() {
        teachers = new Teacher[50];
        teacherCount = 0;
    }


    // Add Teacher ______________________________________________

    public void add(Teacher teacher) {

        if (teacher == null) {
            System.out.println("Teacher cannot be null.");
            return;
        }

        if (teacherCount >= teachers.length) {
            System.out.println("Teacher storage is full.");
            return;
        }

        teachers[teacherCount] = teacher;
        teacherCount++;
    }


    // Add Head Teacher _________________________________________

    public void addHeadTeacher(HeadTeacher headTeacher) {

        if (headTeacher == null) {
            System.out.println("Head teacher cannot be null.");
            return;
        }

        add(headTeacher);
    }


    // Remove By ID _____________________________________________

    public boolean removeById(String id) {

        for (int i = 0; i < teacherCount; i++) {

            if (teachers[i].getId().equals(id)) {

                for (int j = i; j < teacherCount - 1; j++) {
                    teachers[j] = teachers[j + 1];
                }

                teachers[teacherCount - 1] = null;
                teacherCount--;

                return true;
            }
        }

        return false;
    }


    // Get All _________________________________________________

    public Teacher[] getAll() {

        Teacher[] result = new Teacher[teacherCount];

        for (int i = 0; i < teacherCount; i++) {
            result[i] = teachers[i];
        }

        return result;
    }


    // Search By ID _____________________________________________

    public Teacher searchById(String id) {

        for (int i = 0; i < teacherCount; i++) {

            if (teachers[i].getId().equals(id)) {
                return teachers[i];
            }
        }

        return null;
    }


    // Search By Keyword ________________________________________

    public Teacher[] search(String keyword) {

        Teacher[] temp = new Teacher[teacherCount];
        int count = 0;

        for (int i = 0; i < teacherCount; i++) {

            Teacher teacher = teachers[i];

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

                temp[count] = teacher;
                count++;
            }
        }

        Teacher[] result = new Teacher[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
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


    // List By Subject ___________________________________________

    public Teacher[] listBySubject(String subject) {

        Teacher[] temp = new Teacher[teacherCount];
        int count = 0;

        for (int i = 0; i < teacherCount; i++) {

            if (
                    teachers[i]
                            .getSubject()
                            .equalsIgnoreCase(subject)
            ) {

                temp[count] = teachers[i];
                count++;
            }
        }

        Teacher[] result = new Teacher[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // Available Teachers _______________________________________

    public Teacher[] availableTeachers() {

        Teacher[] temp = new Teacher[teacherCount];
        int count = 0;

        for (int i = 0; i < teacherCount; i++) {

            if (teachers[i].getClassesTaught().isEmpty()) {

                temp[count] = teachers[i];
                count++;
            }
        }

        Teacher[] result = new Teacher[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    public int getTeacherCount() {
        return teacherCount;
    }
}