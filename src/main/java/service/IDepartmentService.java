package service;

import model.DepartmentModel;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentModel> findAllDepartment();

    DepartmentModel findOneDepartment(int id);

    DepartmentModel insertDepartment(DepartmentModel departmentModel);

    DepartmentModel updateDepartment(DepartmentModel departmentModel, int id);

    void deleteDepartment(int id);

}
