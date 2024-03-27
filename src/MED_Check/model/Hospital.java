package MED_Check.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private  Long id;
    private  String hospitalName;
    private  String address;
    private List<Departament> departments = new ArrayList<>();
    private  List<Doctor> doctors = new ArrayList<>();
    private  List<Patient> patients = new ArrayList<>( );

    public Hospital() {
    }

    public Hospital(Long id, String hospitalName, String address, List<Departament> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Departament> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departament> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
               "id=" + id +
               ", hospitalName='" + hospitalName + '\'' +
               ", address='" + address + '\'' +
               ", departments=" + departments +
               ", doctors=" + doctors +
               ", patients=" + patients +
               '}';
    }
}
