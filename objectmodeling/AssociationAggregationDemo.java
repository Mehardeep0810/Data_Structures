package Assignment.objectmodeling;

import java.util.*;

class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() { return courseName; }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showStudents() {
        System.out.println("Course: " + courseName);
        if (enrolledStudents.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("  - " + s.getName());
            }
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); 
    }
    public void showCourses() {
        System.out.println("Student: " + name);
        if (courses.isEmpty()) {
            System.out.println("  No courses enrolled.");
        } else {
            for (Course c : courses) {
                System.out.println("  - " + c.getCourseName());
            }
        }
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public String getSchoolName() { return schoolName; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("School: " + schoolName);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student s : students) {
                System.out.println(" - " + s.getName());
            }
        }
    }
}

public class AssociationAggregationDemo {
    public static void main(String[] args) {

        School school = new School("Green Valley School");

        Student s1 = new Student("Mehardeep");
        Student s2 = new Student("Aman");

        school.addStudent(s1);
        school.addStudent(s2);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        s1.enrollInCourse(math);
        s1.enrollInCourse(science);

        s2.enrollInCourse(science);
        s2.enrollInCourse(history);

        school.showStudents();

        s1.showCourses();
        s2.showCourses();

        math.showStudents();
        science.showStudents();
        history.showStudents();
    }
}

