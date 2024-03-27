package MED_Check.service.impl;

import MED_Check.dao.PatientDao;
import MED_Check.dao.impl.PatientDaoImpl;
import MED_Check.generic.GenericService;
import MED_Check.model.Patient;
import MED_Check.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
PatientDao patientDao = new PatientDaoImpl();
GenericService<Patient> patientGenericService = new PatientDaoImpl();
    @Override
    public String add(Long hospitalId, Patient patient) {
        return patientGenericService.add(hospitalId, patient);
    }

    @Override
    public String  removeById(Long hospitalid,Long id) {
return patientGenericService.removeById(hospitalid, id);
    }

    @Override
    public String updateById(Long tId, Patient patient) {
        return patientGenericService.updateById( tId, patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        return patientDao.getPatientByAge(age);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
