package MED_Check.service;

import MED_Check.model.Departament;

import java.util.List;

public interface DepartamentService {
    List<Departament> getAllDepartmentByHospital(Long id);
    Departament findDepartmentByName(String name);
}
