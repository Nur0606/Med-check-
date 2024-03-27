package MED_Check.service.impl;

import MED_Check.dao.DepartamentDao;
import MED_Check.dao.impl.DepartamentDaoImpl;
import MED_Check.generic.GenericService;
import MED_Check.model.Departament;
import MED_Check.service.DepartamentService;

import java.util.List;

public class DepartamentServiceImpl implements DepartamentService, GenericService<Departament> {
    DepartamentDao departamentDao = new DepartamentDaoImpl();
    GenericService<Departament> departamentGenericService = new DepartamentDaoImpl();

    @Override
    public String add(Long hospitalId, Departament departament) {
        return departamentGenericService.add(hospitalId,departament);
    }

    @Override
    public String  removeById(Long hospitalid,Long id) {
       return departamentGenericService.removeById(hospitalid, id);
    }

    @Override
    public String updateById(Long tId, Departament departament) {
        return departamentGenericService.updateById(tId, departament);
    }
    @Override
    public List<Departament> getAllDepartmentByHospital(Long id) {
        return departamentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Departament findDepartmentByName(String name) {
        return departamentDao.findDepartmentByName(name);
    }

}
