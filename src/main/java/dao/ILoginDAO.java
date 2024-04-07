/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.EmployeeModel;

/**
 *
 * @author ThuanBui
 */
public interface ILoginDAO {
    EmployeeModel findUser (String username, String password);
}
