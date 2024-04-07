/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * EmployeeUIPanel.java
 *
 * Created on 07-05-2010, 19:55:35
 */
package views;

import controllers.AdminEmployeeController;
import dao.impl.RoleDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.DepartmentModel;
import model.LocationModel;
import model.RoleModel;
import service.impl.DepartmentService;
import service.impl.LocationService;
import utils.UpdateTable;

/**
 *
 * @author Hoang Dong Tien
 */
public class PnlAdminEmployeeManage extends javax.swing.JPanel {
    
    
    /**
     * Creates new form EmployeeUIPanel
     */
    public PnlAdminEmployeeManage() {
        initComponents();
        ActionListener action = new AdminEmployeeController(this);
        String sql = "Select employee.id, employee.name, employee.username, location.name, department.name, role.name from employee, location, role, department where employee.roleId = role.id and employee.departmentId = department.id and employee.locationID = location.id ORDER BY employee.id ASC";
        UpdateTable.updateTableData(tblData, sql);
        List<LocationModel> locations = new LocationService().findAllLocationModel();
        getData(0);
        cboLocation.addItem("Chọn địa chỉ");

        cboLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboLocation.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboLocation.setSelectedIndex(1);
                }
            }
        });

        cboLocation.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });

        for (LocationModel locationModel : locations) {
            cboLocation.addItem(locationModel.getName());
        }
        
        cboAddLocation.addItem("Chọn địa chỉ");

        cboAddLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboAddLocation.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboAddLocation.setSelectedIndex(1);
                }
            }
        });

        cboAddLocation.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });

        for (LocationModel locationModel : locations) {
            cboAddLocation.addItem(locationModel.getName());
        }
        
        
        cboDepartmentName.addItem("Chọn phòng ban");

        cboDepartmentName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboDepartmentName.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboDepartmentName.setSelectedIndex(1);
                }
            }
        });

        cboDepartmentName.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });

        List<DepartmentModel> departments = new DepartmentService().findAllDepartment();
        for (DepartmentModel department : departments) {
            cboDepartmentName.addItem(department.getName());
        }
        
        cboAddDepartment.addItem("Chọn phòng ban");

        cboAddDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboAddDepartment.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboAddDepartment.setSelectedIndex(1);
                }
            }
        });

        cboAddDepartment.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });

        for (DepartmentModel department : departments) {
            cboAddDepartment.addItem(department.getName());
        }
        
        List<RoleModel> roles = new RoleDAO().findAllRoleModel();
        
        cboAddRole.addItem("Chọn chức vụ");

        cboAddRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboAddRole.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboAddRole.setSelectedIndex(1);
                }
            }
        });

        cboAddRole.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });
        
        for (RoleModel roleModel : roles) {
            cboAddRole.addItem(roleModel.getName());
        }
        
        cboRole.addItem("Chọn chức vụ");

        cboRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboRole.getSelectedIndex() == 0) {
                    // Hiển thị thông báo nếu phần tử đầu tiên được chọn
                    JOptionPane.showMessageDialog(null, "Bạn không thể chọn phần tử này. Vui lòng chọn một lựa chọn khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    cboRole.setSelectedIndex(1);
                }
            }
        });

        cboRole.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.GRAY); // Làm cho văn bản có màu xám để trông như là bị vô hiệu hóa
                } else {
                    setForeground(Color.BLACK); // Màu sắc bình thường cho các lựa chọn khác
                }
                return this;
            }
        });
        
        for (RoleModel roleModel : roles) {
            cboRole.addItem(roleModel.getName());
        }
        
        btnAdd.addActionListener(action);
        btnDelete.addActionListener(action);
        btnSave.addActionListener(action);
        btnSearch.addActionListener(action);
        btnExcel.addActionListener(action);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAdmin = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        tabViewEdit = new javax.swing.JPanel();
        pnlEditEmp = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfEditFullname = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tfEditUsername = new javax.swing.JTextField();
        tfEditEmployeeID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cboLocation = new javax.swing.JComboBox();
        cboDepartmentName = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox();
        pnlSearchCondition = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        tfSearchFullname = new javax.swing.JTextField();
        btnExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        tabAddNew = new javax.swing.JPanel();
        pnlAddEmp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfAddFullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboAddLocation = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboAddDepartment = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        cboAddRole = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfAddPassword1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        tfAddPassword2 = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        tfAddUsername = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(791, 655));
        setLayout(new java.awt.BorderLayout());

        tabbedPane.setMaximumSize(new java.awt.Dimension(791, 655));
        tabbedPane.setMinimumSize(new java.awt.Dimension(791, 655));
        tabbedPane.setPreferredSize(new java.awt.Dimension(791, 655));

        tabViewEdit.setPreferredSize(new java.awt.Dimension(300, 600));
        tabViewEdit.setLayout(new java.awt.BorderLayout());

        pnlEditEmp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlEditEmp.setPreferredSize(new java.awt.Dimension(170, 175));
        pnlEditEmp.setRequestFocusEnabled(false);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
        btnSave.setText("Lưu");

        jLabel11.setText("Địa chỉ");

        jLabel12.setText("Phòng ban");

        jLabel8.setText("Tên đầy đủ");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");

        jLabel20.setText("Tên hiển thị");

        tfEditUsername.setEditable(false);
        tfEditUsername.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        tfEditUsername.setEnabled(false);

        tfEditEmployeeID.setEditable(false);
        tfEditEmployeeID.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        tfEditEmployeeID.setEnabled(false);

        jLabel23.setText("Mã nhân viên");

        cboLocation.setMaximumSize(null);

        cboDepartmentName.setMaximumSize(null);

        jLabel13.setText("Chức vụ");

        cboRole.setMaximumSize(null);

        javax.swing.GroupLayout pnlEditEmpLayout = new javax.swing.GroupLayout(pnlEditEmp);
        pnlEditEmp.setLayout(pnlEditEmpLayout);
        pnlEditEmpLayout.setHorizontalGroup(
            pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditEmpLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEditUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditEmpLayout.createSequentialGroup()
                        .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfEditEmployeeID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEditFullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(102, 102, 102)
                .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlEditEmpLayout.setVerticalGroup(
            pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditEmpLayout.createSequentialGroup()
                .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfEditEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfEditFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEditUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addGap(100, 100, 100))
        );

        tabViewEdit.add(pnlEditEmp, java.awt.BorderLayout.SOUTH);

        pnlSearchCondition.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlSearchCondition.setMaximumSize(null);
        pnlSearchCondition.setPreferredSize(new java.awt.Dimension(100, 130));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");

        jLabel19.setText("Tên");

        btnExcel.setText("Xuất Excel");

        javax.swing.GroupLayout pnlSearchConditionLayout = new javax.swing.GroupLayout(pnlSearchCondition);
        pnlSearchCondition.setLayout(pnlSearchConditionLayout);
        pnlSearchConditionLayout.setHorizontalGroup(
            pnlSearchConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchConditionLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearchFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        pnlSearchConditionLayout.setVerticalGroup(
            pnlSearchConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchConditionLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlSearchConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel19)
                    .addComponent(tfSearchFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tabViewEdit.add(pnlSearchCondition, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Họ tên", "Tên hiển thị", "Địa chỉ", "Phòng ban", "Chức vụ"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        tabViewEdit.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabbedPane.addTab("Nhân viên", new javax.swing.ImageIcon(getClass().getResource("/images/table.png")), tabViewEdit); // NOI18N

        tabAddNew.setPreferredSize(new java.awt.Dimension(350, 330));
        tabAddNew.setLayout(new java.awt.BorderLayout());

        pnlAddEmp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlAddEmp.setPreferredSize(new java.awt.Dimension(150, 250));
        pnlAddEmp.setRequestFocusEnabled(false);

        jLabel1.setText("Tên đầy đủ");

        jLabel2.setText("Địa chỉ");

        cboAddLocation.setMaximumSize(null);

        jLabel3.setText("Phòng ban");

        jLabel4.setText("Mật khẩu");

        cboAddDepartment.setMaximumSize(null);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnAdd.setText("Thêm");

        cboAddRole.setMaximumSize(null);
        cboAddRole.setMinimumSize(new java.awt.Dimension(56, 18));

        jLabel5.setText("Chức vụ");

        jLabel7.setText("Nhắc lại mật khẩu");

        jLabel21.setText("Tên đăng nhập");

        javax.swing.GroupLayout pnlAddEmpLayout = new javax.swing.GroupLayout(pnlAddEmp);
        pnlAddEmp.setLayout(pnlAddEmpLayout);
        pnlAddEmpLayout.setHorizontalGroup(
            pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddEmpLayout.createSequentialGroup()
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAddFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAddUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlAddEmpLayout.createSequentialGroup()
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfAddPassword2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddEmpLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAddPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlAddEmpLayout.setVerticalGroup(
            pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddEmpLayout.createSequentialGroup()
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cboAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAddEmpLayout.createSequentialGroup()
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfAddFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tfAddUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddEmpLayout.createSequentialGroup()
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfAddPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfAddPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAdd))
                .addGap(123, 123, 123))
        );

        tabAddNew.add(pnlAddEmp, java.awt.BorderLayout.NORTH);

        tabbedPane.addTab("Thêm mới nhân viên", new javax.swing.ImageIcon(getClass().getResource("/images/contact-new.png")), tabAddNew); // NOI18N

        add(tabbedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void getData(int row) {
        TableModel model = tblData.getModel();
        tfEditEmployeeID.setText(model.getValueAt(row, 0).toString());
        tfEditFullname.setText((String) model.getValueAt(row, 1));
        tfEditUsername.setText(model.getValueAt(row, 2).toString());
        String location = (String) model.getValueAt(row, 3);
        cboLocation.getModel().setSelectedItem(location);
        String department = (String) model.getValueAt(row, 4);
        cboDepartmentName.getModel().setSelectedItem(department);
        String role = (String) model.getValueAt(row, 5);
        cboRole.getModel().setSelectedItem(role);
    }

    public void tblDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyReleased
//        if (tblData.getSelectedRow() != -1) {
//            loadEditData();
//        }
    }//GEN-LAST:event_tblDataKeyReleased

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        if (tblData.getSelectedRow() != -1) {
            getData(tblData.getSelectedRow());
        }
    }//GEN-LAST:event_tblDataMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PnlAdminEmployeeManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.ButtonGroup btnGroupAdmin;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnSearch;
    public javax.swing.JComboBox cboAddDepartment;
    public javax.swing.JComboBox cboAddLocation;
    public javax.swing.JComboBox cboAddRole;
    public javax.swing.JComboBox cboDepartmentName;
    public javax.swing.JComboBox cboLocation;
    public javax.swing.JComboBox cboRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAddEmp;
    private javax.swing.JPanel pnlEditEmp;
    private javax.swing.JPanel pnlSearchCondition;
    private javax.swing.JPanel tabAddNew;
    private javax.swing.JPanel tabViewEdit;
    private javax.swing.JTabbedPane tabbedPane;
    public javax.swing.JTable tblData;
    public javax.swing.JTextField tfAddFullname;
    public javax.swing.JPasswordField tfAddPassword1;
    public javax.swing.JPasswordField tfAddPassword2;
    public javax.swing.JTextField tfAddUsername;
    public javax.swing.JTextField tfEditEmployeeID;
    public javax.swing.JTextField tfEditFullname;
    public javax.swing.JTextField tfEditUsername;
    public javax.swing.JTextField tfSearchFullname;
    // End of variables declaration//GEN-END:variables
}
