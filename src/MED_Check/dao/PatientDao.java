package MED_Check.dao;

import MED_Check.model.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDao {
    String addPatientsToHospital(Long id, List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge(int age);
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
