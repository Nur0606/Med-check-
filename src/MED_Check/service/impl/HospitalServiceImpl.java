package MED_Check.service.impl;

import MED_Check.dao.HospitalDao;
import MED_Check.dao.impl.HospitalDaoImpl;
import MED_Check.model.Hospital;
import MED_Check.model.Patient;
import MED_Check.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    HospitalDao hospitalDao = new HospitalDaoImpl();
    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
