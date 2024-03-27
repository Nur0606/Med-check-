package MED_Check.dao.impl;

import MED_Check.dao.DepartamentDao;
import MED_Check.db.Database;
import MED_Check.generic.GenericService;
import MED_Check.model.Departament;
import MED_Check.model.Hospital;

import java.util.List;

public class DepartamentDaoImpl implements DepartamentDao, GenericService<Departament> {


    @Override
    public String add(Long hospitalId, Departament departament) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalId)) {
                getHospital.getDepartments().add(departament);
                return "Success saved!";
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public String  removeById(Long hospitalid,Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(hospitalid)){
                for (Departament department : getHospital.getDepartments()) {
                    if (department.getId().equals(id)){
                         getHospital.getDepartments().remove(department);
                         return "Success deleted!";
                    }
                }
            }
        }
        return "Hospital Not-Found!";
    }

    @Override
    public String updateById(Long Id, Departament departament) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Departament department : getHospital.getDepartments()) {
                if (department.getId().equals(Id)) {
                    department.setDepartmentName(departament.getDepartmentName());
                    return "Success updates";
                }
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public List<Departament> getAllDepartmentByHospital(Long id) {
        for (Hospital getHospital : Database.getHospitals) {
            if (getHospital.getId().equals(id)){
                return getHospital.getDepartments();
            }
        }
        System.out.println("Hospital Not-Found!");
        return null;
    }

    @Override
    public Departament findDepartmentByName(String name) {
        for (Hospital getHospital : Database.getHospitals) {
            for (Departament department : getHospital.getDepartments()) {
                if (department.getDepartmentName().equalsIgnoreCase(name));
                return department;
            }
        }
        System.out.println("Department Not-Found!");
        return null;
    }
}
