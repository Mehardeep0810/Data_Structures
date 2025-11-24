package Assignment.objectmodeling;

import java.util.*;

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " (" + specialization + 
                           ") is consulting patient " + patient.getName());
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showDoctors() {
        System.out.println("Doctors at " + hospitalName + ":");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.getName() + " (" + d.getSpecialization() + ")");
        }
    }

    public void showPatients() {
        System.out.println("Patients at " + hospitalName + ":");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Mehardeep", "Cardiologist");
        Doctor d2 = new Doctor("Aman", "Neurologist");

        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Alice");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        hospital.showDoctors();
        hospital.showPatients();

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}

