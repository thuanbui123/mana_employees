package dao.impl;

import dao.IEmployeeDAO;
import mapper.EmployeeMapper;
import model.EmployeeModel;

import java.util.List;

public class EmployeeDAO extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {
    @Override
    public List<EmployeeModel> findAllEmployee() {
        String sql = "SELECT * FROM employee, department, location, role WHERE employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id ORDER BY employee.name ASC";
        return query(sql, new EmployeeMapper());
    }

    @Override
    public EmployeeModel findOneEmployee(int id) {
        String sql = "SELECT * FROM employee, department, location, role WHERE employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id AND employee.id = ?";
        if (query(sql, new EmployeeMapper(), id) != null && !query(sql, new EmployeeMapper(), id).isEmpty())
            return query(sql, new EmployeeMapper(), id).get(0);
        return null;
    }

    @Override
    public EmployeeModel insertEmployee(EmployeeModel employeeModel) {
        String sql = "INSERT INTO employee (name, username, password, departmentId, locationId, roleId, isAdmin) VALUES (? , ? , ? , ? , ? , ?, ?)";
        boolean isAdmin = false;
        if(employeeModel.getRole().getName().equals("Leader")) isAdmin = true;
        Long id = insert(sql, employeeModel.getName(), employeeModel.getUsername(), employeeModel.getPassword(), employeeModel.getDepartment().getId(), employeeModel.getLocation().getId(), employeeModel.getRole().getId(), isAdmin);
        return findOneEmployee(Integer.parseInt(id.toString()));
    }

    @Override
    public void updateEmployee(EmployeeModel employeeModel, int id) {
        String sql = "UPDATE employee SET name = ?, departmentId = ?, locationId = ?, roleId = ? WHERE id = ?";
        update(sql, employeeModel.getName(), employeeModel.getDepartment().getId(), employeeModel.getLocation().getId(), employeeModel.getRole().getId(), id);
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        update(sql, id);
    }

    @Override
    public boolean isEmployeeOnProject(int id) {
        String sql = "SELECT * FROM employee, department, location, role, employeesonproject WHERE employee.id = employeesonproject.idEmployee and employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id and employee.id = ?";
        if (query(sql, new EmployeeMapper(), id) != null && !query(sql, new EmployeeMapper(), id).isEmpty()) return true;
        return false;
    }
}
