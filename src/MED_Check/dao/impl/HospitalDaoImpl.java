package MED_Check.dao.impl;

import MED_Check.dao.HospitalDao;
import MED_Check.db.Database;
import MED_Check.model.Hospital;
import MED_Check.model.Patient;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public String addHospital(Hospital hospital) {
        Database.getHospitals.add(hospital);
        return "Success saved!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)){
                return getHospital;
            }
        }
        System.out.println("Not-Found!");
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.getHospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)){
                return getHospital.getPatients();
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)){
                Database.getHospitals.remove(getHospital);
                return"Success deleted!";
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String ,Hospital> map = new LinkedHashMap<>();
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getAddress().equalsIgnoreCase(address)){
                map.put(getHospital.getAddress(),getHospital);
                return map;
            }
        }
        System.out.println("Address Not-Found!");
        return null;
    }
}
