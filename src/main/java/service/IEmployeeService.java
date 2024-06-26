package service;

import model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeModel> findAllEmployee();

    EmployeeModel findOneEmployee(int id);

    EmployeeModel insertEmployee(EmployeeModel employeeModel);

    EmployeeModel updateEmployee(EmployeeModel employeeModel, int id);

    boolean isEmployeeOnProject (int id);
    
    void deleteEmployee(int id);
    
    void deleteEmployeeOnProject(int id);
}
