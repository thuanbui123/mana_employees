package views;


import controllers.MainFrameController;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import utils.SetStyleComponentUtil;
public class MainFrame extends javax.swing.JFrame {
    public ActionListener action = new MainFrameController(this);
    public MainFrame() {
        initComponents();
//        setFrameStyle();
        boolean role = true;
        if (role == true ) setAdminLayout();
        else setUserLayout();
        SetStyleComponentUtil<PnlAdminEmployeeManage> setStyle = new SetStyleComponentUtil<>();
        setStyle.setFrameStyle(new PnlAdminEmployeeManage(), spltPane);
//       user
        btnHomeEmp.addActionListener(action);
        btnRequestTransfer.addActionListener(action);
        btnEmpTransferManage.addActionListener(action);
        btnProjectList.addActionListener(action);
        btnDepartmentList.addActionListener(action);
        btnLocationList.addActionListener(action);
        btnEmpMyProfile.addActionListener(action);
        btnLogout1.addActionListener(action);
//        admin
        btnEmployeeManage.addActionListener(action);
        btnDepartmentManage.addActionListener(action);
        btnLocationManage.addActionListener(action);
        btnProjectManage.addActionListener(action);
        btnStatistical.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        scrlPaneLeftUser = new javax.swing.JScrollPane();
        pnlLeftEmp = new javax.swing.JPanel();
        btnEmpMyProfile = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnEmpTransferManage = new javax.swing.JButton();
        btnRequestTransfer = new javax.swing.JButton();
        btnHomeEmp = new javax.swing.JButton();
        btnDepartmentList = new javax.swing.JButton();
        btnProjectList = new javax.swing.JButton();
        btnLocationList = new javax.swing.JButton();
        spltPane = new javax.swing.JSplitPane();
        scrlpaneLeftAdmin = new javax.swing.JScrollPane();
        pnlLeft = new javax.swing.JPanel();
        btnProjectManage = new javax.swing.JButton();
        btnDepartmentManage = new javax.swing.JButton();
        btnLocationManage = new javax.swing.JButton();
        btnEmployeeManage = new javax.swing.JButton();
        btnStatistical = new javax.swing.JButton();
        pnlHome5 = new javax.swing.JPanel();
        menuBarMain = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        mnuiLogout = new javax.swing.JMenuItem();
        mnuiExit = new javax.swing.JMenuItem();

        scrlPaneLeftUser.setMaximumSize(null);
        scrlPaneLeftUser.setMinimumSize(null);
        scrlPaneLeftUser.setPreferredSize(new java.awt.Dimension(225, 235));

        pnlLeftEmp.setMaximumSize(new java.awt.Dimension(185, 539));
        pnlLeftEmp.setMinimumSize(new java.awt.Dimension(185, 539));
        pnlLeftEmp.setPreferredSize(new java.awt.Dimension(185, 539));

        btnEmpMyProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
        btnEmpMyProfile.setText("My Profile");
        btnEmpMyProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpMyProfileActionPerformed(evt);
            }
        });

        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnLogout1.setText("Logout");
        btnLogout1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout1ActionPerformed(evt);
            }
        });

        btnEmpTransferManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Transfermanage.png"))); // NOI18N
        btnEmpTransferManage.setText("My Transfers Manage");
        btnEmpTransferManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpTransferManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpTransferManageActionPerformed(evt);
            }
        });

        btnRequestTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transferNew.png"))); // NOI18N
        btnRequestTransfer.setText("Request New Transfer");
        btnRequestTransfer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRequestTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTransferActionPerformed(evt);
            }
        });

        btnHomeEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnHomeEmp.setText("Home");
        btnHomeEmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHomeEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeEmpActionPerformed(evt);
            }
        });

        btnDepartmentList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Department.png"))); // NOI18N
        btnDepartmentList.setText("Departments List");
        btnDepartmentList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDepartmentList.setMaximumSize(new java.awt.Dimension(101, 41));
        btnDepartmentList.setMinimumSize(new java.awt.Dimension(101, 41));
        btnDepartmentList.setPreferredSize(new java.awt.Dimension(79, 25));
        btnDepartmentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentListActionPerformed(evt);
            }
        });

        btnProjectList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
        btnProjectList.setText("Projects List");
        btnProjectList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProjectList.setMaximumSize(new java.awt.Dimension(101, 41));
        btnProjectList.setMinimumSize(new java.awt.Dimension(101, 41));
        btnProjectList.setPreferredSize(new java.awt.Dimension(79, 25));
        btnProjectList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectListActionPerformed(evt);
            }
        });

        btnLocationList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Location.png"))); // NOI18N
        btnLocationList.setText("Locations List");
        btnLocationList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLocationList.setMaximumSize(new java.awt.Dimension(101, 41));
        btnLocationList.setMinimumSize(new java.awt.Dimension(101, 41));
        btnLocationList.setPreferredSize(new java.awt.Dimension(79, 25));
        btnLocationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLeftEmpLayout = new javax.swing.GroupLayout(pnlLeftEmp);
        pnlLeftEmp.setLayout(pnlLeftEmpLayout);
        pnlLeftEmpLayout.setHorizontalGroup(
            pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHomeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRequestTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpTransferManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnProjectList, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLocationList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(pnlLeftEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmpMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlLeftEmpLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDepartmentList, btnEmpMyProfile, btnEmpTransferManage, btnHomeEmp, btnLocationList, btnLogout1, btnProjectList, btnRequestTransfer});

        pnlLeftEmpLayout.setVerticalGroup(
            pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHomeEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequestTransfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpTransferManage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProjectList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpMyProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout1)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pnlLeftEmpLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDepartmentList, btnEmpMyProfile, btnEmpTransferManage, btnHomeEmp, btnLocationList, btnLogout1, btnProjectList, btnRequestTransfer});

        scrlPaneLeftUser.setViewportView(pnlLeftEmp);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Transfer Management");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        spltPane.setDividerLocation(220);
        spltPane.setDividerSize(0);
        spltPane.setEnabled(false);
        spltPane.setMaximumSize(null);
        spltPane.setPreferredSize(new java.awt.Dimension(1024, 543));

        scrlpaneLeftAdmin.setMaximumSize(null);
        scrlpaneLeftAdmin.setMinimumSize(null);
        scrlpaneLeftAdmin.setPreferredSize(new java.awt.Dimension(219, 541));

        pnlLeft.setMaximumSize(new java.awt.Dimension(185, 539));
        pnlLeft.setMinimumSize(new java.awt.Dimension(185, 539));
        pnlLeft.setPreferredSize(new java.awt.Dimension(185, 539));

        btnProjectManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
        btnProjectManage.setText("Quản lý dự án");
        btnProjectManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProjectManage.setMaximumSize(new java.awt.Dimension(101, 41));
        btnProjectManage.setMinimumSize(new java.awt.Dimension(101, 41));
        btnProjectManage.setPreferredSize(new java.awt.Dimension(79, 25));
        btnProjectManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectManageActionPerformed(evt);
            }
        });

        btnDepartmentManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Department.png"))); // NOI18N
        btnDepartmentManage.setText("Quản lý phòng ban");
        btnDepartmentManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDepartmentManage.setMaximumSize(new java.awt.Dimension(101, 41));
        btnDepartmentManage.setMinimumSize(new java.awt.Dimension(101, 41));
        btnDepartmentManage.setPreferredSize(new java.awt.Dimension(79, 25));
        btnDepartmentManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentManageActionPerformed(evt);
            }
        });

        btnLocationManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Location.png"))); // NOI18N
        btnLocationManage.setText("Quản lý địa chỉ");
        btnLocationManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLocationManage.setMaximumSize(new java.awt.Dimension(101, 41));
        btnLocationManage.setMinimumSize(new java.awt.Dimension(101, 41));
        btnLocationManage.setPreferredSize(new java.awt.Dimension(79, 25));
        btnLocationManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationManageActionPerformed(evt);
            }
        });

        btnEmployeeManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        btnEmployeeManage.setText("Quản lý nhân viên");
        btnEmployeeManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmployeeManage.setMaximumSize(new java.awt.Dimension(101, 41));
        btnEmployeeManage.setMinimumSize(new java.awt.Dimension(101, 41));
        btnEmployeeManage.setPreferredSize(new java.awt.Dimension(79, 25));
        btnEmployeeManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManageActionPerformed(evt);
            }
        });

        btnStatistical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/statistical.jpg"))); // NOI18N
        btnStatistical.setText("Thống kê");
        btnStatistical.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProjectManage, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnDepartmentManage, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnLocationManage, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnEmployeeManage, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnStatistical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnEmployeeManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProjectManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDepartmentManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocationManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStatistical)
                .addContainerGap(807, Short.MAX_VALUE))
        );

        pnlLeftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDepartmentManage, btnEmployeeManage, btnLocationManage, btnProjectManage});

        scrlpaneLeftAdmin.setViewportView(pnlLeft);

        spltPane.setLeftComponent(scrlpaneLeftAdmin);

        pnlHome5.setMaximumSize(null);
        pnlHome5.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout pnlHome5Layout = new javax.swing.GroupLayout(pnlHome5);
        pnlHome5.setLayout(pnlHome5Layout);
        pnlHome5Layout.setHorizontalGroup(
            pnlHome5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        pnlHome5Layout.setVerticalGroup(
            pnlHome5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );

        spltPane.setRightComponent(pnlHome5);

        getContentPane().add(spltPane, java.awt.BorderLayout.CENTER);

        menuFile.setText("File");

        mnuiLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        mnuiLogout.setText("Logout");
        mnuiLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiLogoutActionPerformed(evt);
            }
        });
        menuFile.add(mnuiLogout);

        mnuiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        mnuiExit.setText("Exit Application");
        mnuiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiExitActionPerformed(evt);
            }
        });
        menuFile.add(mnuiExit);

        menuBarMain.add(menuFile);

        setJMenuBar(menuBarMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mnuiLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiLogoutActionPerformed
//        logOut();
    }//GEN-LAST:event_mnuiLogoutActionPerformed

    //Thoát khỏi ứng dụng
    public void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiExitActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn thực sự muốn thoát khỏi ?", "Đã thoát", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnuiExitActionPerformed

    public void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JLogin login = new JLogin();
        login.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public void btnEmpTransferManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpTransferManageActionPerformed
    
  

    }//GEN-LAST:event_btnEmpTransferManageActionPerformed

    public void btnRequestTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTransferActionPerformed
 
   
    }//GEN-LAST:event_btnRequestTransferActionPerformed

    public void btnHomeEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeEmpActionPerformed
        
    }//GEN-LAST:event_btnHomeEmpActionPerformed

    public void btnDepartmentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentListActionPerformed
//        PnlUserDepartmentList deptEmpPnl = new PnlUserDepartmentList();
//        spltPane.setRightComponent(deptEmpPnl);
    }//GEN-LAST:event_btnDepartmentListActionPerformed

    public void btnProjectListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectListActionPerformed
     
    }//GEN-LAST:event_btnProjectListActionPerformed

    public void btnLocationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationListActionPerformed
//        PnlUserLocationList empLocLst = new PnlUserLocationList();
//        spltPane.setRightComponent(empLocLst);
    }//GEN-LAST:event_btnLocationListActionPerformed

    public void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
//        logOut();
    }//GEN-LAST:event_btnLogout1ActionPerformed

    public void btnEmpMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpMyProfileActionPerformed
   
    }//GEN-LAST:event_btnEmpMyProfileActionPerformed

    public void btnEmployeeManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManageActionPerformed
//                PnlAdminEmployeeManage pnlEmp = new PnlAdminEmployeeManage();
//                spltPane.setRightComponent(pnlEmp);
    }//GEN-LAST:event_btnEmployeeManageActionPerformed

    public void btnLocationManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationManageActionPerformed
        //        PnlAdminLocationManage pnlLocationManage = new PnlAdminLocationManage();
        //        spltPane.setRightComponent(pnlLocationManage);
    }//GEN-LAST:event_btnLocationManageActionPerformed

    public void btnDepartmentManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentManageActionPerformed
        //        PnlAdminDepartmentManage pnlDepartmentManage = new PnlAdminDepartmentManage();
        //        spltPane.setRightComponent(pnlDepartmentManage);
    }//GEN-LAST:event_btnDepartmentManageActionPerformed

    public void btnProjectManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectManageActionPerformed
        //        PnlAdminProjectManage pnlPrj = new PnlAdminProjectManage();
        //        spltPane.setRightComponent(pnlPrj);
    }//GEN-LAST:event_btnProjectManageActionPerformed

   

    /*Xác nhận và đăng nhập hệ thống*/
//    public void logOut() {
//        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát khỏi hệ thống ?", "Thoát", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
//            curEmp = null;
//            Main.frmLogin.setVisible(true);
//            this.dispose();
//        }
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    /*Quản trị*/
    public void setAdminLayout() {
        scrlPaneLeftUser.setVisible(false);//ẩn bảng người dùng

        scrlpaneLeftAdmin.setVisible(true);//hiện và thêm của người dùng
        spltPane.setLeftComponent(scrlpaneLeftAdmin);

        this.setTitle(this.getTitle() + " - SYSTEM ADMINISTRATOR");
    }

    /*Phong cửa sổ bình thường*/
    public void setUserLayout() {
        scrlpaneLeftAdmin.setVisible(false);//ẩn bảng Admin

        scrlPaneLeftUser.setVisible(true);
        spltPane.setLeftComponent(this.scrlPaneLeftUser);//hiện và thêm bảng người dùng

        this.setTitle(this.getTitle() + " - NORMAL USER");
    }
////kích thước frame
//    public void setFrameStyle() {
//   
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int height = screenSize.height;
//        int width = screenSize.width;
//
//        setBounds((width - 1024) / 2, (height - 768) / 2, 1024, 768);
//
//        setIconImage((new ImageIcon("wire_transfer.png")).getImage());
//
//        setFont(new Font("Verdana", Font.BOLD, 10));
//        PnlAdminEmployeeManage employeeManage = new PnlAdminEmployeeManage();
//        spltPane.setRightComponent(employeeManage);
//    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDepartmentList;
    public javax.swing.JButton btnDepartmentManage;
    public javax.swing.JButton btnEmpMyProfile;
    public javax.swing.JButton btnEmpTransferManage;
    public javax.swing.JButton btnEmployeeManage;
    public javax.swing.JButton btnHomeEmp;
    public javax.swing.JButton btnLocationList;
    public javax.swing.JButton btnLocationManage;
    public javax.swing.JButton btnLogout1;
    public javax.swing.JButton btnProjectList;
    public javax.swing.JButton btnProjectManage;
    public javax.swing.JButton btnRequestTransfer;
    public javax.swing.JButton btnStatistical;
    public javax.swing.JMenuBar menuBarMain;
    public javax.swing.JMenu menuFile;
    public javax.swing.JMenuItem mnuiExit;
    public javax.swing.JMenuItem mnuiLogout;
    public javax.swing.JPanel pnlHome5;
    public javax.swing.JPanel pnlLeft;
    public javax.swing.JPanel pnlLeftEmp;
    public javax.swing.JScrollPane scrlPaneLeftUser;
    public javax.swing.JScrollPane scrlpaneLeftAdmin;
    public javax.swing.JSplitPane spltPane;
    // End of variables declaration//GEN-END:variables
//    public int EmployeeId;
}
