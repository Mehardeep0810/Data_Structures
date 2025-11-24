package Assignment.objectmodeling;

import java.util.*;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showEmployees() {
        System.out.println("Department: " + deptName);
        if (employees.isEmpty()) {
            System.out.println("  No employees.");
        } else {
            for (Employee e : employees) {
                System.out.println("  - " + e);
            }
        }
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        if (departments.isEmpty()) {
            System.out.println("No departments.");
        } else {
            for (Department d : departments) {
                d.showEmployees();
            }
        }
    }

    public void deleteCompany() {
        System.out.println("Deleting company: " + companyName);
        departments.clear(); 
    }
}


public class CompositionDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department devDept = new Department("Development");
        devDept.addEmployee("Alice", "Software Engineer");
        devDept.addEmployee("Bob", "Backend Developer");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Charlie", "HR Manager");

        company.addDepartment(devDept);
        company.addDepartment(hrDept);

        company.showCompanyStructure();

        company.deleteCompany();

        company.showCompanyStructure();
    }
}

