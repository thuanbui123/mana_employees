package dao;

import model.EmployeeModel;

import java.util.List;

public interface IEmployeeDAO {
    List<EmployeeModel> findAllEmployee();

    EmployeeModel findOneEmployee(int id);
    
    EmployeeModel insertEmployee(EmployeeModel employeeModel);

    void updateEmployee(EmployeeModel employeeModel, int id);

    void deleteEmployee(int id);
}
