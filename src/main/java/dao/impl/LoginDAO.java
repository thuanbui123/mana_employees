/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ILoginDAO;
import mapper.EmployeeMapper;
import model.EmployeeModel;

/**
 *
 * @author ThuanBui
 */
public class LoginDAO extends AbstractDAO<EmployeeModel> implements ILoginDAO{

    @Override
    public EmployeeModel findUser(String username, String password) {
        String sql = "SELECT * FROM employee, department, location, role WHERE employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id AND employee.username = ? AND employee.password = ?";
        if(query(sql, new EmployeeMapper(), username, password) != null && !query(sql, new EmployeeMapper(), username, password).isEmpty()) {
            return query(sql, new EmployeeMapper(), username, password).get(0);
        }
        return null;
    }
    
}
