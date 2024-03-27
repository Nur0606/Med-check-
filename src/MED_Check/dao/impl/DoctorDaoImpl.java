package MED_Check.dao.impl;

import MED_Check.dao.DoctorDao;
import MED_Check.db.Database;
import MED_Check.generic.GenericService;
import MED_Check.model.Departament;
import MED_Check.model.Doctor;
import MED_Check.model.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao, GenericService<Doctor> {
    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalId)) {
                getHospital.getDoctors().add(doctor);
                return "Success saved!";
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public String removeById(Long hospitalid, Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalid)) {
                for (Doctor doctor : getHospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        getHospital.getDoctors().remove(doctor);
                        return "Success deleted!";
                    }
                }
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public String updateById(Long Id, Doctor doctor) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Doctor getHospitalDoctor : getHospital.getDoctors()) {
                if (getHospitalDoctor.getId().equals(Id)) {
                    getHospitalDoctor.setFirstName(doctor.getFirstName());
                    getHospitalDoctor.setLastName(doctor.getLastName());
                    getHospitalDoctor.setGender(doctor.getGender());
                    getHospitalDoctor.setExperienceYear(doctor.getExperienceYear());
                    return "Success updates!";
                }
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Doctor doctor : getHospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
        }
        System.out.println("Doctor Not-Found!");
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : Database.getHospitals) {
            for (Departament departament : hospital.getDepartments()) {
                if (departament.getId().equals(departmentId)) {
                    for (Doctor doctor : hospital.getDoctors()) {
                        if (doctorsId.contains(doctor.getId())) {
                            departament.getDoctors().add(doctor);
                            hospital.getDoctors().remove(doctor);
                            return "Success assign";
                        }
                    }
                }
            }
        }
        return "Not-Found!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)) {
                return getHospital.getDoctors();
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Departament department : getHospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    return department.getDoctors();
                }
            }
        }
        System.out.println("Not-Found!");
        return null;
    }

}
