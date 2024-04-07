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
                    String sql = "Select employee.id, employee.name, employee.username, location.name, department.name, role.name from employee, location, role, department where employee.roleId = role.id and employee.departmentId = department.id and employee.locationID = location.id ORDER BY employee.id ASC";
                    UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);

                } else {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu không khớp", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else if (action.equals("Lưu")) {
            Integer id = Integer.valueOf(this.PnlAdminEmployeeManage.tfEditEmployeeID.getText());
            String fullName = this.PnlAdminEmployeeManage.tfEditFullname.getText();
            String location = (String) this.PnlAdminEmployeeManage.cboLocation.getSelectedItem();
            LocationModel locationModel = new LocationDAO().findOneLocationModelByName(location);
            String department = this.PnlAdminEmployeeManage.cboDepartmentName.getSelectedItem().toString();
            DepartmentModel departmentModel = new DepartmentDAO().findOneDepartmentByName(department);
            String role = this.PnlAdminEmployeeManage.cboRole.getSelectedItem().toString();
            RoleModel roleModel = new RoleDAO().findOneRoleModelByName(role);
            EmployeeModel employeeModel = new EmployeeModel(fullName, departmentModel, locationModel, roleModel);
            EmployeeModel saveEmployeeModel = employeeService.updateEmployee(employeeModel, id);
            if (saveEmployeeModel != null) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                String sql = "Select employee.id, employee.name, employee.username, location.name, department.name, role.name from employee, location, role, department where employee.roleId = role.id and employee.departmentId = department.id and employee.locationID = location.id ORDER BY employee.id ASC";
                UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
            }
        } else if (action.equals("Tìm kiếm")) {
            String name = this.PnlAdminEmployeeManage.tfSearchFullname.getText();
            String sql = "Select employee.id, employee.name, employee.username, location.name, department.name \n"
                    + "from employee, location, department \n"
                    + "where employee.departmentId = department.id and employee.locationID = location.id and employee.name LIKE \"%" + name + "%\"";
            UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);
        } else if (action.equals("Xóa")) {
            Integer id = Integer.valueOf(this.PnlAdminEmployeeManage.tfEditEmployeeID.getText());
            int Selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên có mã " + id, "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
            if (Selection == JOptionPane.OK_OPTION) {
                if (employeeService.isEmployeeOnProject(id)) {
                    employeeService.deleteEmployeeOnProject(id);
                }
                employeeService.deleteEmployee(id);
                EmployeeModel employeeModel = employeeService.findOneEmployee(id);
                if (employeeModel != null) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa không thành công");
                }
                String sql = "Select employee.id, employee.name, employee.username, location.name, department.name, role.name from employee, location, role, department where employee.roleId = role.id and employee.departmentId = department.id and employee.locationID = location.id ORDER BY employee.id ASC";
                UpdateTable.updateTableData(this.PnlAdminEmployeeManage.tblData, sql);
                this.PnlAdminEmployeeManage.getData(0);
            }
        }
    }

}
