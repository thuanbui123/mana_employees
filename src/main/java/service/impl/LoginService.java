/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.impl.LoginDAO;
import model.EmployeeModel;
import service.ILoginService;

/**
 *
 * @author ThuanBui
 */
public class LoginService implements ILoginService {

    private LoginDAO loginDAO = new LoginDAO();

    EmployeeModel findUser(String username, String password) {
        return loginDAO.findUser(username, password);
    }

    @Override
    public int login(String username, String password) {
        EmployeeModel employeeModel = findUser(username, password);
        if (employeeModel != null) {
            if (employeeModel.getRole().getName().equals("Leader")) {
                return 1;
            }
            return 2;
        } else {
            return 0;
        }
    }

}
