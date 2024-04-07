/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import model.DepartmentModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.impl.DepartmentService;
import utils.ExportDataUtils;
import utils.UpdateTable;
import views.PnlAdminDepartmentManage;

/**
 *
 * @author Tan
 */
public class DepartmentController implements ActionListener {
    
    private final DepartmentService departmentService = new DepartmentService();
    private final PnlAdminDepartmentManage pnlAdminDepartmentManage;
    
    public DepartmentController(PnlAdminDepartmentManage pnlAdminDepartmentManage) {
        this.pnlAdminDepartmentManage = pnlAdminDepartmentManage;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        String sqlNomal = "SELECT \n"
                + "    d.id AS department_id,\n"
                + "    d.name AS department_name,\n"
                + "    COUNT(e.id) AS employee_count\n"
                + "FROM \n"
                + "    department d\n"
                + "LEFT JOIN \n"
                + "    employee e ON d.id = e.departmentId\n"
                + "GROUP BY \n"
                + "    d.id, d.name;";
        
        if (action.equals("Thêm")) {
//            this.pnlAdminDepartmentManage.tfDepartmentID.setText("");
//            this.pnlAdminDepartmentManage.tfDepartmentName.setText("");
//            this.pnlAdminDepartmentManage.tfDepartmentName.requestFocus();

            String name = this.pnlAdminDepartmentManage.tfDepartmentName.getText().trim();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this.pnlAdminDepartmentManage, "Tên phòng ban không được để trống!");
                return;
            }
            
            DepartmentModel departmentModel = new DepartmentModel(0, name);
            DepartmentModel isInsert = departmentService.insertDepartment(departmentModel);
            if (isInsert != null) {
                JOptionPane.showMessageDialog(null, "Thêm phòng ban thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                pnlAdminDepartmentManage.renderDataTable(sqlNomal);
                pnlAdminDepartmentManage.getData(0);
                this.pnlAdminDepartmentManage.tfDepartmentName.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else if (action.equals("Sửa")) {
            this.pnlAdminDepartmentManage.tfDepartmentName.requestFocus();
            String name = this.pnlAdminDepartmentManage.tfDepartmentName.getText().trim();
            int id = Integer.parseInt(this.pnlAdminDepartmentManage.tfDepartmentID.getText());
            
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this.pnlAdminDepartmentManage, "Tên phòng ban không được để trống!");
                return;
            }
            
            DepartmentModel departmentModel = new DepartmentModel(0, name);
            departmentService.updateDepartment(departmentModel, id);
            pnlAdminDepartmentManage.renderDataTable(sqlNomal);
        } else if (action.equals("Xóa")) {
            int id = Integer.parseInt(this.pnlAdminDepartmentManage.tfDepartmentID.getText());
            int row = pnlAdminDepartmentManage.tblData.getSelectedRow();
            int count = Integer.parseInt(pnlAdminDepartmentManage.tblData.getModel().getValueAt(row, 2).toString());
            if (count == 0) {
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phòng ban này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    boolean isDeleted = departmentService.deleteDepartment(id);
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Xóa phòng ban thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        pnlAdminDepartmentManage.renderDataTable(sqlNomal);
                        pnlAdminDepartmentManage.getData(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Phòng ban đang có nhân viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if (action.equals("Tìm kiếm")) {
            String keyword = this.pnlAdminDepartmentManage.tfDepartmentSearch.getText();
            if (keyword != null && !keyword.isEmpty()) {
                pnlAdminDepartmentManage.renderDataTable("SELECT \n"
                        + "    d.id AS department_id,\n"
                        + "    d.name AS department_name,\n"
                        + "    COUNT(e.id) AS employee_count\n"
                        + "FROM \n"
                        + "    department d\n"
                        + "LEFT JOIN \n"
                        + "    employee e ON d.id = e.departmentId\n"
                        + "Where d.name like \"%" + keyword + "%\"\n"
                        + "GROUP BY \n"
                        + "    d.id, d.name;");
                
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên phòng ban cần tìm kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                this.pnlAdminDepartmentManage.tfDepartmentSearch.requestFocus();
            }
        } else if (action.equals("Hủy")) {
            pnlAdminDepartmentManage.renderDataTable(sqlNomal);
            pnlAdminDepartmentManage.getData(0);
        } else if (action.equals("Xuất Excel")) {
            ExportDataUtils exportDataUtils = new ExportDataUtils();
            try {
                exportDataUtils.exportTable(pnlAdminDepartmentManage.tblData);
            } catch (IOException ex) {
                Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
