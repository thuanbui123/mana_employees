package dao;

import model.DepartmentModel;

import java.util.List;

public interface IDepartmentDAO {

    List<DepartmentModel> findAllDepartment();

    DepartmentModel findOneDepartment(int id);

    DepartmentModel findOneDepartmentByName(String name);
    
    void insertDepartment(DepartmentModel departmentModel);

    void updateDepartment(DepartmentModel departmentModel, int id);

    void deleteDepartment(int id);

}
