/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utils.SetStyleComponentUtil;
import views.MainFrame;
import views.PnlAdminDepartmentManage;
import views.PnlAdminEmployeeManage;
import views.PnlAdminLocationManage;
import views.PnlAdminProjectManage;
import views.PnlStatistical;

/**
 *
 * @author ThuanBui
 */
public class MainFrameController implements ActionListener {

    private MainFrame mainFrame;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Home")) {
//            JOptionPane.showMessageDialog(null, "Home");
        } else if (action.equals("Request New Transfer")) {
            JOptionPane.showMessageDialog(null, "Request New Transfer");
        } else if (action.equals("My Transfers Manage")) {
            JOptionPane.showMessageDialog(null, "My Transfers Manage");
        } else if (action.equals("Projects List")) {
            JOptionPane.showMessageDialog(null, "Projects List");
        } else if (action.equals("Departments List")) {
            JOptionPane.showMessageDialog(null, "Departments List");
        } else if (action.equals("Locations List")) {
            JOptionPane.showMessageDialog(null, "Locations List");
        } else if (action.equals("My Profile")) {
            JOptionPane.showMessageDialog(null, "My Profile");
        } else if (action.equals("Logout")) {
            JOptionPane.showMessageDialog(null, "Logout");
        } else if (action.equals("Quản lý nhân viên")) {
            SetStyleComponentUtil<PnlAdminEmployeeManage> setStyle = new SetStyleComponentUtil<>();
            setStyle.setFrameStyle(new PnlAdminEmployeeManage(), this.mainFrame.spltPane);
        } else if (action.equals("Quản lý dự án")) {
            SetStyleComponentUtil<PnlAdminProjectManage> setStyle = new SetStyleComponentUtil<>();
            setStyle.setFrameStyle(new PnlAdminProjectManage(), this.mainFrame.spltPane);
        } else if (action.equals("Quản lý phòng ban")) {
            SetStyleComponentUtil<PnlAdminDepartmentManage> setStyle = new SetStyleComponentUtil<>();
            setStyle.setFrameStyle(new PnlAdminDepartmentManage(), this.mainFrame.spltPane);
        } else if (action.equals("Quản lý địa chỉ")) {
            SetStyleComponentUtil<PnlAdminLocationManage> setStyle = new SetStyleComponentUtil<>();
            setStyle.setFrameStyle(new PnlAdminLocationManage(), this.mainFrame.spltPane);
        } else if (action.equals("Thống kê")) {
            SetStyleComponentUtil<PnlStatistical> setStyle = new SetStyleComponentUtil<>();
            setStyle.setFrameStyle(new PnlStatistical(), this.mainFrame.spltPane);
        }
    }

}
