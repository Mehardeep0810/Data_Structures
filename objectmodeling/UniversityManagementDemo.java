package Assignment.objectmodeling;

import java.util.*;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() { return courseName; }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println("Student " + student.getName() + " enrolled in " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("  Professor: " + professor.getName());
        } else {
            System.out.println("  No professor assigned yet.");
        }
        if (enrolledStudents.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            System.out.println("  Students:");
            for (Student s : enrolledStudents) {
                System.out.println("   - " + s.getName());
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

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void showCourses() {
        System.out.println("Student: " + name + " enrolled in:");
        if (courses.isEmpty()) {
            System.out.println("  No courses.");
        } else {
            for (Course c : courses) {
                System.out.println("  - " + c.getCourseName());
            }
        }
    }
}

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void assignCourse(Course course) {
        courses.add(course);
        course.assignProfessor(this);
    }

    public void showCourses() {
        System.out.println("Professor: " + name + " teaches:");
        if (courses.isEmpty()) {
            System.out.println("  No courses assigned.");
        } else {
            for (Course c : courses) {
                System.out.println("  - " + c.getCourseName());
            }
        }
    }
}

class University {
    private String universityName;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showUniversityStructure() {
        System.out.println("University: " + universityName);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println(" - " + p.getName());
        }
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        University uni = new University("Punjab University");

        Student s1 = new Student("Mehardeep");
        Student s2 = new Student("Aman");

        Professor p1 = new Professor("Dr. Sharma");
        Professor p2 = new Professor("Dr. Kaur");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        uni.showUniversityStructure();
        
        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
        c1.showCourseDetails();
        c2.showCourseDetails();
    }
}

