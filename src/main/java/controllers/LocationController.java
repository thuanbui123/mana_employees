/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LocationModel;
import service.impl.LocationService;
import utils.UpdateTable;
import views.PnlAdminLocationManage;

public class LocationController implements ActionListener {

    private static LocationService locationService = new LocationService();
    private PnlAdminLocationManage pnlAdminLocationManage;

    public LocationController(PnlAdminLocationManage pnlAdminLocationManage) {
        this.pnlAdminLocationManage = pnlAdminLocationManage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Thêm")) {
            String name = this.pnlAdminLocationManage.tfAddLocationName.getText().trim();
            LocationModel locationModel = new LocationModel(name);
            if (!name.equals("")) {
                long id = locationService.insertLocationModel(locationModel);
                if (id > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm địa chỉ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    this.pnlAdminLocationManage.renderDataTable();
                    this.pnlAdminLocationManage.tfAddLocationName.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    this.pnlAdminLocationManage.renderDataTable();
                }
            } else {
                JOptionPane.showMessageDialog(this.pnlAdminLocationManage, "Địa chỉ không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else if (action.equals("Sửa")) {
            int id = Integer.parseInt(this.pnlAdminLocationManage.tfEditLocationId.getText());
            String name = this.pnlAdminLocationManage.tfEditLocationName.getText().trim();
            LocationModel locationModel = new LocationModel(name);
            if (!name.equals("")) {
                LocationModel locationModel1 = locationService.updateLocationModel(locationModel, id);
                this.pnlAdminLocationManage.renderDataTable();
                if (locationModel1 != null && !name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Sửa địa chỉ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    this.pnlAdminLocationManage.renderDataTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Sửathất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    this.pnlAdminLocationManage.renderDataTable();
                }
            } else {
                JOptionPane.showMessageDialog(this.pnlAdminLocationManage, "Địa chỉ không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else if (action.equals("Tìm kiếm")) {
            String name = this.pnlAdminLocationManage.tfAddLocationName.getText().trim();
            String sql = "SELECT * FROM location WHERE name LIKE '%" + name + "%'";
            UpdateTable.updateTableData(this.pnlAdminLocationManage.tblData, sql);
        } else if (action.equals("Xóa")) {
            int confirm = JOptionPane.showConfirmDialog(this.pnlAdminLocationManage, "Bạn chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(this.pnlAdminLocationManage.tfEditLocationId.getText());
              locationService.deleteLocationModel(id);
                JOptionPane.showMessageDialog(this.pnlAdminLocationManage, "Xóa thành công");
                this.pnlAdminLocationManage.renderDataTable();
                this.pnlAdminLocationManage.getData(0);
            }
        }
    }

}
