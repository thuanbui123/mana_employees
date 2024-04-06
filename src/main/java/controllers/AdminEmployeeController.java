/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.impl.DepartmentDAO;
import dao.impl.LocationDAO;
import dao.impl.RoleDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DepartmentModel;
import model.EmployeeModel;
import model.LocationModel;
import model.RoleModel;
import service.impl.EmployeeService;
import utils.UpdateTable;
import views.PnlAdminEmployeeManage;

/**
 *
 * @author ThuanBui
 */
public class AdminEmployeeController implements ActionListener {

    private PnlAdminEmployeeManage PnlAdminEmployeeManage;
    private static EmployeeService employeeService = new EmployeeService();

    public AdminEmployeeController(PnlAdminEmployeeManage PnlAdminEmployeeManage) {
        this.PnlAdminEmployeeManage = PnlAdminEmployeeManage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Thêm")) {
            String fullName = this.PnlAdminEmployeeManage.tfAddFullname.getText();
            String username = this.PnlAdminEmployeeManage.tfAddUsername.getText();
            String password = this.PnlAdminEmployeeManage.tfAddPassword1.getText();
            String rePassword = this.PnlAdminEmployeeManage.tfAddPassword2.getText();
            String location = this.PnlAdminEmployeeManage.cboAddLocation.getSelectedItem().toString();
            LocationModel locationModel = new LocationDAO().findOneLocationModelByName(location);
            String department = this.PnlAdminEmployeeManage.cboAddDepartment.getSelectedItem().toString();
            DepartmentModel departmentModel = new DepartmentDAO().findOneDepartmentByName(department);
            String role = this.PnlAdminEmployeeManage.cboAddRole.getSelectedItem().toString();
            RoleModel roleModel = new RoleDAO().findOneRoleModelByName(role);
            if (password.equals(rePassword)) {
                EmployeeModel employeeModel = new EmployeeModel(fullName, username, password, departmentModel, locationModel, roleModel);
                boolean isInsert = employeeService.insertData(employeeModel);
                if (isInsert) {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    String sql = "Select employee.id, employee.name, employee.username, location.name, department.name from employee, location, department where employee.departmentId = department.id and employee.locationID = location.id";
                    UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);

                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu không khớp", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else if (action.equals("Lưu")) {
            JOptionPane.showMessageDialog(null, "Save");
        } else if (action.equals("Tìm kiếm")) {
            String name = this.PnlAdminEmployeeManage.tfSearchFullname.getText();
            String sql = "Select employee.id, employee.name, employee.username, location.name, department.name from employee, location, department where employee.departmentId = department.id and employee.locationID = location.id and employee.name = N'" + name + "'";
            UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);
        } else if (action.equals("Xóa")) {
            JOptionPane.showMessageDialog(null, "Delete");
        }
    }

}