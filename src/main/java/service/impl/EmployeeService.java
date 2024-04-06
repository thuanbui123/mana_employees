package service.impl;

import dao.impl.EmployeeDAO;
import model.EmployeeModel;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public List<EmployeeModel> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }

    @Override
    public EmployeeModel findOneEmployee(int id) {
        return employeeDAO.findOneEmployee(id);
    }

    @Override
    public EmployeeModel insertEmployee(EmployeeModel employeeModel) {
        if (employeeModel.getName() == null && employeeModel.getName().isEmpty() || employeeModel.getUsername() == null && employeeModel.getUsername().isEmpty() || employeeModel.getPassword() == null && employeeModel.getPassword().isEmpty()) {
            return null;
        }
        return employeeDAO.insertEmployee(employeeModel);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employeeModel, int id) {
        if (employeeModel.getName() == null && employeeModel.getName().isEmpty() || employeeModel.getUsername() == null && employeeModel.getUsername().isEmpty() || employeeModel.getPassword() == null && employeeModel.getPassword().isEmpty()) {
            return null;
        }
        employeeDAO.updateEmployee(employeeModel, id);
        return findOneEmployee(employeeModel.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
    
    public boolean insertData(EmployeeModel employeeModel) {
        EmployeeModel saveEmployee = insertEmployee(employeeModel);
        if (saveEmployee == null) return false;
        return true;
    }
    
}
