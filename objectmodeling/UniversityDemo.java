package Assignment.objectmodeling;

import java.util.*;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return name + " (" + specialization + ")";
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() { return deptName; }

    @Override
    public String toString() {
        return deptName;
    }
}

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showStructure() {
        System.out.println("University: " + universityName);

        System.out.println("Departments:");
        if (departments.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Department d : departments) {
                System.out.println("  - " + d);
            }
        }

        System.out.println("Faculties:");
        if (faculties.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Faculty f : faculties) {
                System.out.println("  - " + f);
            }
        }
    }

    public void deleteUniversity() {
        System.out.println("Deleting University: " + universityName);
        departments.clear();
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University uni = new University("Punjab Technical University");

        Department cs = new Department("Computer Science");
        Department mech = new Department("Mechanical Engineering");

        uni.addDepartment(cs);
        uni.addDepartment(mech);

        Faculty f1 = new Faculty("Dr. Mehardeep", "AI & ML");
        Faculty f2 = new Faculty("Dr. Aman", "Thermodynamics");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showStructure();

        uni.deleteUniversity();

        uni.showStructure();

        System.out.println("Independent Faculties:");
        System.out.println(f1);
        System.out.println(f2);
    }
}

