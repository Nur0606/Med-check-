package MED_Check.generic;

import MED_Check.model.Departament;

public interface GenericService<T> {
    String add(Long  hospitalId, T t);

    String removeById(Long hospitalid, Long Tid);

    String updateById(Long Id, T t);

}
