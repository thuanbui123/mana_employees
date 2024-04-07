package views;

import controllers.LocationController;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import model.LocationModel;
import service.impl.LocationService;
import utils.UpdateTable;

public final class PnlAdminLocationManage extends javax.swing.JPanel {

    /**
     * Creates new form ManageLocation
     */
    public PnlAdminLocationManage() {
        initComponents();

        ActionListener action = new LocationController(this);
        String sql = "Select *from  location";
        UpdateTable.updateTableData(tblData, sql);
        List<LocationModel> locations = new LocationService().findAllLocationModel();
        getData(0);
        btnThemLocation.addActionListener(action);
        btnSave.addActionListener(action);
        btnDelete.addActionListener(action);
        btnSearch.addActionListener(action);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
// Thiết lập căn chỉnh của renderer về bên trái
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
// Thiết lập renderer cho cột muốn hiển thị dữ liệu về bên trái
        tblData.getColumnModel().getColumn(0).setCellRenderer(renderer);
//tblData.getColumnModel().getColumn(1).setCellRenderer(renderer);
    }

    public void getData(int row) {
        TableModel model = tblData.getModel();

        // Kiểm tra xem chỉ số row có hợp lệ không
        if (row >= 0 && row < model.getRowCount()) {
            tfEditLocationId.setText(model.getValueAt(row, 0).toString());
            tfEditLocationName.setText((String) model.getValueAt(row, 1));
        } else {
            // Xử lý trường hợp chỉ số không hợp lệ ở đây
            // Ví dụ: hiển thị thông báo lỗi, không thực hiện gì cả, vv.
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        pnlAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnThemLocation = new javax.swing.JButton();
        tfAddLocationName = new javax.swing.JTextField();
        pnlEdit = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfEditLocationId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEditLocationName = new javax.swing.JTextField();
        pnlBottom = new javax.swing.JPanel();
        spnlLocationData = new javax.swing.JScrollPane();
        spnlLocationData1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(791, 655));
        setMinimumSize(new java.awt.Dimension(791, 655));
        setPreferredSize(new java.awt.Dimension(791, 655));
        setLayout(new java.awt.BorderLayout());

        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlAdd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm địa chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlAdd.setPreferredSize(new java.awt.Dimension(554, 120));

        jLabel2.setText("Địa chỉ");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");

        btnThemLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnThemLocation.setText("Thêm");
        btnThemLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLocationActionPerformed(evt);
            }
        });

        tfAddLocationName.setMaximumSize(null);

        javax.swing.GroupLayout pnlAddLayout = new javax.swing.GroupLayout(pnlAdd);
        pnlAdd.setLayout(pnlAddLayout);
        pnlAddLayout.setHorizontalGroup(
            pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnThemLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAddLayout.setVerticalGroup(
            pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemLocation)
                    .addComponent(btnSearch)
                    .addComponent(tfAddLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pnlTop.add(pnlAdd, java.awt.BorderLayout.NORTH);

        pnlEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlEdit.setPreferredSize(new java.awt.Dimension(554, 150));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
        btnSave.setText("Sửa");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã địa chỉ");

        tfEditLocationId.setEditable(false);
        tfEditLocationId.setEnabled(false);
        tfEditLocationId.setMaximumSize(null);

        jLabel4.setText("Địa chỉ");

        tfEditLocationName.setMaximumSize(null);

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(tfEditLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(tfEditLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEditLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(tfEditLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pnlTop.add(pnlEdit, java.awt.BorderLayout.CENTER);

        add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách địa chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlBottom.setLayout(new java.awt.BorderLayout());

        spnlLocationData.setBorder(null);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã địa chỉ ", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        spnlLocationData1.setViewportView(tblData);

        spnlLocationData.setViewportView(spnlLocationData1);

        pnlBottom.add(spnlLocationData, java.awt.BorderLayout.PAGE_START);

        add(pnlBottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLocationActionPerformed

    }//GEN-LAST:event_btnThemLocationActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyReleased
//        loadEditData();
}//GEN-LAST:event_tblDataKeyReleased
    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        if (tblData.getSelectedRow() != -1) {
            getData(tblData.getSelectedRow());
        }
}//GEN-LAST:event_tblDataMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed
    
    public void renderDataTable() {
//        String sql = "SELECT * FROM department";
        String sql = "select * from location";
        UpdateTable.updateTableData(tblData, sql);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new PnlAdminLocationManage().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThemLocation;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane spnlLocationData;
    private javax.swing.JScrollPane spnlLocationData1;
    public javax.swing.JTable tblData;
    public javax.swing.JTextField tfAddLocationName;
    public javax.swing.JTextField tfEditLocationId;
    public javax.swing.JTextField tfEditLocationName;
    // End of variables declaration//GEN-END:variables

}
