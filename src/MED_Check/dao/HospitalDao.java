package MED_Check.dao;

import MED_Check.model.Hospital;
import MED_Check.model.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {
    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}
