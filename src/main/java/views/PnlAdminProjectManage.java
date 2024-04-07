package views;

import controllers.ProjectController;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.EmployeeModel;
import model.ProjectModel;
import service.impl.EmployeeService;
import service.impl.ProjectService;

public final class PnlAdminProjectManage extends javax.swing.JPanel {

    public ActionListener action = new ProjectController(this);

    /**
     * Creates new form ProjectUIPanel
     */
    public PnlAdminProjectManage() {
        initComponents();
        ArrayList<ProjectModel> listProjects = (ArrayList) projectService.findAllProjectModel();
        if (listProjects != null) {
            this.generateModelDefaltTable(listProjects);
        }
        btnAdd.addActionListener(action);
        btnDelete.addActionListener(action);
        btnUpdate.addActionListener(action);
        btnSeach.addActionListener(action);
        btnDone.addActionListener(action);
        btnCancel.addActionListener(action);
        btnExcel.addActionListener(action);
        comboboxMemberSelected();
        comboboxMemberEditSelected();
        mapperTableValue();
        noneEditable();

    }

    private ComboBoxModel<CheckableItem> makeModel() {
        ArrayList<EmployeeModel> listEmployees = (ArrayList<EmployeeModel>) employeeService.findAllEmployee();
        ArrayList<CheckableItem> checkableItems = new ArrayList<>();

        if (listEmployees != null) {
            for (EmployeeModel employee : listEmployees) {
                checkableItems.add(new CheckableItem(employee.getId(), employee.getName(), false));
            }
        }
        CheckableItem[] listItems = checkableItems.toArray(new CheckableItem[0]);
        return new DefaultComboBoxModel<>(listItems);
    }

    public void mapperTableValue() {
        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                btnAdd.setEnabled(false);
                btnDelete.setEnabled(true);
                btnUpdate.setEnabled(true);
                btnDone.setEnabled(true);

                int row = tblData.getSelectedRow();
                int column = tblData.getSelectedColumn();

                if (row != -1 && column != -1) { // Check if a valid cell is selected
                    Object id = tblData.getModel().getValueAt(row, 0);
                    idEdit = (int) id;
                    ProjectModel projectModel = projectService.findOneProjectModel((int) id);
                    txtNameEdit.setText(projectModel.getName());
                    ArrayList<EmployeeModel> listEmployees1 = (ArrayList<EmployeeModel>) employeeService.findAllEmployee();
                    ArrayList<CheckableItem> checkableItems = new ArrayList<>();

                    if (listEmployees1 != null) {
                        for (EmployeeModel employee : listEmployees1) {
                            checkableItems.add(new CheckableItem(employee.getId(), employee.getName(), false));
                        }
                    }
                    for (CheckableItem checkableItem : checkableItems) {
                        for (EmployeeModel employeeModel : projectModel.getList()) {
                            if (employeeModel.getName().equals(checkableItem.getText())) {
                                checkableItem.setSelected(true);
                                listEmployees.add(employeeModel);
                            }
                        }
                    }
                    CheckableItem[] listItems = checkableItems.toArray(new CheckableItem[0]);
                    cbxMemberEdit.setModel(new DefaultComboBoxModel<>(listItems));
                }
            }
        });
    }

    public void noneEditable() {
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDone.setEnabled(false);
        btnAdd.setEnabled(true);
    }

    public void clearForm() {
        txtNameProject.setText("");
        txtNameEdit.setText("");
    }

    public void comboboxMemberSelected() {
        cbxMember.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Lấy giá trị được chọn
                    CheckableItem selectedItem = (CheckableItem) e.getItem();
                    if (selectedItem.isSelected() == true) {
//                        Xử lý giá trị được chọn ở đây
                        EmployeeModel employeeModel = new EmployeeModel();
                        employeeModel.setId(selectedItem.getId());
                        employeeModel.setName(selectedItem.getText());
                        if (!listEmployees.contains(employeeModel)) {
                            System.out.println("Contains");
                            listEmployees.add(employeeModel);
                        }
                    } else {
                        listEmployees.remove(selectedItem.getId() - 1);
                    }
                }
            }
        });
    }

    public void comboboxMemberEditSelected() {
        cbxMemberEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Lấy giá trị được chọn
                    CheckableItem selectedItem = (CheckableItem) e.getItem();
                    // Xử lý giá trị được chọn ở đây
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.setId(selectedItem.getId());
                    employeeModel.setName(selectedItem.getText());
                    if (selectedItem.isSelected() == false) {
                        listEmployeesEdit.removeAll(listEmployeesEdit);
                    } else {
                        listEmployeesEdit.add(employeeModel);
                    }
                }
            }
        });
    }

    public void generateModelDefaltTable(ArrayList<ProjectModel> filtedProject) {

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (ProjectModel project : filtedProject) {
            if (project != null) {
                String member = "";

                String tinhtrang = project.getStatus() == 1 ? "Hoàn Thành" : "Chưa Hoàn Thành";

                for (EmployeeModel employeeModel : project.getList()) {
                    member += employeeModel.getName() + ", ";
                }
                Object[] rowData = {project.getId(), project.getName(), member, project.getCreatedAt(),
                    tinhtrang};
                model.addRow(rowData);
            } else {
                System.out.println("Project Is null");
            }
        }
        tblData.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        pnlAddNew = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtNameProject = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        cbxMember = new CheckBoxCombobox<>(makeModel());
        lblMember = new javax.swing.JLabel();
        pnlEdit = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblNameEdit = new javax.swing.JLabel();
        txtNameEdit = new javax.swing.JTextField();
        lblMemberEdit = new javax.swing.JLabel();
        cbxMemberEdit = new CheckBoxCombobox<>(makeModel());
        txtSearch = new javax.swing.JTextField();
        btnSeach = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        pnlBottom = new javax.swing.JPanel();
        sclPaneData = new javax.swing.JScrollPane();
        sclPaneData1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(791, 655));
        setMinimumSize(new java.awt.Dimension(791, 655));
        setPreferredSize(new java.awt.Dimension(791, 655));
        setLayout(new java.awt.BorderLayout());

        pnlTop.setPreferredSize(new java.awt.Dimension(671, 160));
        pnlTop.setRequestFocusEnabled(false);
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlAddNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm mới dự án", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlAddNew.setPreferredSize(new java.awt.Dimension(671, 80));

        lblName.setText("Tên dự án");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png")));
        btnAdd.setText("Thêm mới");

        lblMember.setText("Thành viên");

        javax.swing.GroupLayout pnlAddNewLayout = new javax.swing.GroupLayout(pnlAddNew);
        pnlAddNew.setLayout(pnlAddNewLayout);
        pnlAddNewLayout.setHorizontalGroup(
            pnlAddNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameProject, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cbxMember, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        pnlAddNewLayout.setVerticalGroup(
            pnlAddNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddNewLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlAddNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtNameProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMember, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(lblMember))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnlTop.add(pnlAddNew, java.awt.BorderLayout.NORTH);

        pnlEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlEdit.setPreferredSize(new java.awt.Dimension(671, 80));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png")));
        btnUpdate.setText("Cập nhật");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png")));
        btnDelete.setText("Xóa");

        lblNameEdit.setText("Tên dự án");

        lblMemberEdit.setText("Thành viên");

        btnSeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png")));
        btnSeach.setText("Tìm kiếm");

        btnDone.setText("Hoàn Thành");

        btnCancel.setText("Hủy");

        btnExcel.setText("Xuất Excel");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(lblNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(btnSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(cbxMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameEdit)
                    .addComponent(cbxMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMemberEdit)
                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeach)
                    .addComponent(btnDone)
                    .addComponent(btnCancel))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlTop.add(pnlEdit, java.awt.BorderLayout.CENTER);

        add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dự án", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        pnlBottom.setLayout(new java.awt.BorderLayout());

        sclPaneData.setBorder(null);

        sclPaneData1.setBorder(null);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Thứ tự", "Tên dự án", "Thành viên", "Ngày bắt đầu", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sclPaneData1.setViewportView(tblData);

        sclPaneData.setViewportView(sclPaneData1);

        pnlBottom.add(sclPaneData, java.awt.BorderLayout.CENTER);

        add(pnlBottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public final ProjectService projectService = new ProjectService();
    private final EmployeeService employeeService = new EmployeeService();
    String[] columnNames = {"Thứ tự", "Tên dự án", "Thành viên", "Ngày bắt đầu", "Tình trạng"};
    public ArrayList<EmployeeModel> listEmployees = new ArrayList<>();
    public ArrayList<EmployeeModel> listEmployeesEdit = new ArrayList<>();
    public int idEdit = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnDone;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnSeach;
    public javax.swing.JButton btnUpdate;
    public CheckBoxCombobox  cbxMember;
    public CheckBoxCombobox  cbxMemberEdit;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblMemberEdit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameEdit;
    private javax.swing.JPanel pnlAddNew;
    public javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane sclPaneData;
    public javax.swing.JScrollPane sclPaneData1;
    public javax.swing.JTable tblData;
    public javax.swing.JTextField txtNameEdit;
    public javax.swing.JTextField txtNameProject;
    public javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
