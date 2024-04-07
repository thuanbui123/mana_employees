/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ProjectModel;
import service.impl.ProjectService;
import utils.ExportDataUtils;
import views.PnlAdminProjectManage;

/**
 *
 * @author Admin
 */
public class ProjectController implements ActionListener {

    private final PnlAdminProjectManage pnlAdminProjectManage;
    private final ProjectService projectService = new ProjectService();

    public ProjectController(PnlAdminProjectManage pnlAdminProjectManage) {
        this.pnlAdminProjectManage = pnlAdminProjectManage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {
            case "Thêm mới" -> {
                String nameProject = pnlAdminProjectManage.txtNameProject.getText();

                if (nameProject.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tên dự ");
                    break;
                }
                if (pnlAdminProjectManage.listEmployees.size() < 1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn thành viên trong dự án");
                    break;
                } else {
                    ProjectModel projectModel = new ProjectModel(nameProject, 0, pnlAdminProjectManage.listEmployees);
                    ProjectModel projectModel1 = projectService.insertProjectModel(projectModel);

                    if (projectModel1 == null) {
                        JOptionPane.showMessageDialog(null, "Thêm dự án không thành công");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm dự án thành công");
                        pnlAdminProjectManage.generateModelDefaltTable((ArrayList) projectService.findAllProjectModel());
                        pnlAdminProjectManage.clearForm();

                    }
                }
                pnlAdminProjectManage.noneEditable();
                break;
            }
            case "Cập nhật" -> {
                String nameProject = pnlAdminProjectManage.txtNameEdit.getText();
                if (nameProject.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tên dự ");
                }
                if (pnlAdminProjectManage.listEmployees.size() < 1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn thành viên trong dự án");
                } else {
                    ProjectModel projectModel = new ProjectModel(nameProject, 0, pnlAdminProjectManage.listEmployeesEdit);
                    ProjectModel projectModel1 = projectService.updateProjectModel(projectModel, pnlAdminProjectManage.idEdit);
                    if (projectModel1 == null) {
                        JOptionPane.showMessageDialog(null, "Sửa dự án không thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa dự án thành công");
                        pnlAdminProjectManage.generateModelDefaltTable((ArrayList) projectService.findAllProjectModel());
                        pnlAdminProjectManage.clearForm();
                    }
                    pnlAdminProjectManage.clearForm();
                }
                pnlAdminProjectManage.noneEditable();
                break;
            }

            case "Xóa" -> {

                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dự án không", "Delete", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    ProjectModel projectModel1 = projectService.deleteProjectModel(pnlAdminProjectManage.idEdit);
                    if (projectModel1 == null) {
                        JOptionPane.showMessageDialog(null, "Xóa dự án thành công");
                        pnlAdminProjectManage.generateModelDefaltTable((ArrayList) projectService.findAllProjectModel());
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa dự án không thành công");
                    }
                    pnlAdminProjectManage.clearForm();
                }
                pnlAdminProjectManage.noneEditable();
                break;
            }

            case "Tìm kiếm" -> {
                String nameProject = pnlAdminProjectManage.txtSearch.getText();
                ArrayList<ProjectModel> listProjects = (ArrayList<ProjectModel>) projectService.searchProject(nameProject);
                pnlAdminProjectManage.generateModelDefaltTable(listProjects);
                break;
            }
            case "Hoàn Thành" -> {
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dự án không", "Delete", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    ProjectModel projectModel1 = projectService.updateDoneProject(pnlAdminProjectManage.idEdit, 1);
                    if (projectModel1 != null) {
                        JOptionPane.showMessageDialog(null, "Hoàn thành dự án");
                        pnlAdminProjectManage.generateModelDefaltTable((ArrayList) projectService.findAllProjectModel());
                    } else {
                        JOptionPane.showMessageDialog(null, "Chưa hoàn thành");
                    }
                }
                pnlAdminProjectManage.noneEditable();
                pnlAdminProjectManage.clearForm();
            }
            case "Xuất Excel" -> {
                ExportDataUtils exportDataUtils = new ExportDataUtils();
                try {
                    exportDataUtils.exportTable(pnlAdminProjectManage.tblData);
                } catch (IOException ex) {
                    Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "Hủy" -> {
                pnlAdminProjectManage.clearForm();
                pnlAdminProjectManage.noneEditable();

            }
            default ->
                throw new AssertionError();
        }
    }

}
