package MED_Check.dao.impl;

import MED_Check.dao.PatientDao;
import MED_Check.db.Database;
import MED_Check.generic.GenericService;
import MED_Check.model.Hospital;
import MED_Check.model.Patient;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PatientDaoImpl implements PatientDao, GenericService<Patient> {
    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalId)) {
                getHospital.getPatients().add(patient);
                return "Success saved!";
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public String removeById(Long hospitalid, Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalid)) {
                for (Patient patient : getHospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        getHospital.getPatients().remove(patient);
                        return "Success deleted!";
                    }
                }
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public String updateById(Long Id, Patient patient) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Patient getHospitalPatient : getHospital.getPatients()) {
                if (getHospitalPatient.getId().equals(Id)) {
                    getHospitalPatient.setFirstName(patient.getFirstName());
                    getHospitalPatient.setLastName(patient.getLastName());
                    getHospitalPatient.setAge(patient.getAge());
                    getHospitalPatient.setGender(patient.getGender());
                    return "Success updates!";
                }
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)){
                getHospital.getPatients().addAll(patients);
                return "Success saved";
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Patient patient : getHospital.getPatients()) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
        }
        System.out.println("Patient Not-Found!");
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> map = new LinkedHashMap<>();
        for (Hospital getHospital : Database.getHospitals) {
            for (Patient patient : getHospital.getPatients()) {
                if (patient.getAge() == age) {
                    map.put(patient.getAge(), patient);

                }
            }
        }
        return map;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital getHospital : Database.getHospitals) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                getHospital.getPatients().sort(Comparator.comparingInt(Patient::getAge));
                return getHospital.getPatients();
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                getHospital.getPatients().sort(Comparator.comparingInt(Patient::getAge).reversed());
                return getHospital.getPatients();
            }
        }
        System.out.println("Tuura jaz!");
        return null;
    }


}
