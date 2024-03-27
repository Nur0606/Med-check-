package MED_Check.service.impl;

import MED_Check.dao.DoctorDao;
import MED_Check.dao.impl.DoctorDaoImpl;
import MED_Check.generic.GenericService;
import MED_Check.model.Doctor;
import MED_Check.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    DoctorDao dao = new DoctorDaoImpl();
    GenericService<Doctor> service = new DoctorDaoImpl();
    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return dao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return dao.getAllDoctorsByDepartmentId(id);
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return service.add(hospitalId, doctor);
    }

    @Override
    public String removeById(Long hospitalid,Long id) {
        return service.removeById(hospitalid, id);
    }

    @Override
    public String updateById(Long tId, Doctor doctor) {
        return service.updateById(tId, doctor);
    }
    @Override
    public Doctor findDoctorById(Long id) {
        return dao.findDoctorById(id);
    }
    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return dao.assignDoctorToDepartment(departmentId, doctorsId);
    }


}
