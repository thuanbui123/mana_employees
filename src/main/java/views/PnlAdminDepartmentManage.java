package views;

import controllers.DepartmentController;
import java.awt.event.ActionListener;
import javax.swing.table.TableModel;
import utils.UpdateTable;

public final class PnlAdminDepartmentManage extends javax.swing.JPanel {

    /**
     * Tạo mới form ManageDepartment
     */
    public PnlAdminDepartmentManage() {
        initComponents();
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
        renderDataTable(sqlNomal);
        getData(0);
        ActionListener action = new DepartmentController(this);
        btnAdd.addActionListener(action);
        btnUpdate.addActionListener(action);
        btnClear.addActionListener(action);
        btnSearch.addActionListener(action);
        btnDelete.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        pnlDepartment = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        tfDepartmentID = new javax.swing.JTextField();
        tfDepartmentName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        tfDepartmentSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        spnlDepartmentData = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(791, 655));
        setLayout(new java.awt.BorderLayout());

        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlDepartment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng ban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlDepartment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDepartment.setPreferredSize(new java.awt.Dimension(707, 125));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnAdd.setText("Thêm");

        tfDepartmentID.setEditable(false);
        tfDepartmentID.setEnabled(false);
        tfDepartmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDepartmentIDActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã phòng ban");

        jLabel5.setText("Tên phòng ban");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-clear.png"))); // NOI18N
        btnClear.setText("Hủy");
        btnClear.setToolTipText("");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");

        jLabel7.setText("Tìm kiếm");

        javax.swing.GroupLayout pnlDepartmentLayout = new javax.swing.GroupLayout(pnlDepartment);
        pnlDepartment.setLayout(pnlDepartmentLayout);
        pnlDepartmentLayout.setHorizontalGroup(
            pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepartmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDepartmentLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDepartmentLayout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnDelete)
                        .addGap(75, 75, 75)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDepartmentLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(tfDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDepartmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pnlDepartmentLayout.setVerticalGroup(
            pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepartmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDepartmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnSearch))
                .addGap(22, 22, 22))
        );

        pnlTop.add(pnlDepartment, java.awt.BorderLayout.PAGE_START);

        add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng ban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlBottom.setLayout(new java.awt.BorderLayout());

        spnlDepartmentData.setBorder(null);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phòng ban", "Tên phòng ban ", "Số lượng nhân viên"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        spnlDepartmentData.setViewportView(tblData);

        pnlBottom.add(spnlDepartmentData, java.awt.BorderLayout.CENTER);

        add(pnlBottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void renderDataTable(String sql) {
//        String sql = "SELECT * FROM department";
        
        UpdateTable.updateTableData(tblData, sql);
    }

    public void getData(int row) {
        TableModel model = tblData.getModel();
        if (row >= 0 && row < model.getRowCount()) {
            tfDepartmentID.setText(model.getValueAt(row, 0).toString());
            tfDepartmentName.setText((String) model.getValueAt(row, 1));
        }
    }
    
    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        if (tblData.getSelectedRow() != -1) {
            getData(tblData.getSelectedRow());
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void tblDataCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblDataCaretPositionChanged
    }//GEN-LAST:event_tblDataCaretPositionChanged

    private void tblDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyPressed
    }//GEN-LAST:event_tblDataKeyPressed

    private void tblDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyTyped
    }//GEN-LAST:event_tblDataKeyTyped

    private void tblDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyReleased
        if (tblData.getSelectedRow() != -1) {
            getData(tblData.getSelectedRow());
        }
    }//GEN-LAST:event_tblDataKeyReleased

    private void tfDepartmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDepartmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDepartmentIDActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnSearch;
    public javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlDepartment;
    private javax.swing.JPanel pnlTop;
    public javax.swing.JScrollPane spnlDepartmentData;
    public javax.swing.JTable tblData;
    public javax.swing.JTextField tfDepartmentID;
    public javax.swing.JTextField tfDepartmentName;
    public javax.swing.JTextField tfDepartmentSearch;
    // End of variables declaration//GEN-END:variables

}
