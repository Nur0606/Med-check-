package MED_Check.dao;

import MED_Check.model.Departament;

import java.util.List;

public interface DepartamentDao {
    List<Departament> getAllDepartmentByHospital(Long id);
    Departament findDepartmentByName(String name);
}
