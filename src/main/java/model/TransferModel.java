package model;

public class TransferModel extends AbstractModel{

    private EmployeeModel employee;
    private boolean status;
    private String nameFromProject;
    private String nameToProject;
    private String nameFromDepartment;
    private String nameToDepartment;
    private String nameFromLocation;
    private String nameToLocation;
    private String transferRelivingDate;
    private String transferJoinDate;

    public TransferModel(int id, EmployeeModel employee, boolean status, String nameFromProject, String nameToProject, String nameFromDepartment, String nameToDepartment, String nameFromLocation, String nameToLocation, String transferRelivingDate, String transferJoinDate) {
        super(id);
        this.employee = employee;
        this.status = status;
        this.nameFromProject = nameFromProject;
        this.nameToProject = nameToProject;
        this.nameFromDepartment = nameFromDepartment;
        this.nameToDepartment = nameToDepartment;
        this.nameFromLocation = nameFromLocation;
        this.nameToLocation = nameToLocation;
        this.transferRelivingDate = transferRelivingDate;
        this.transferJoinDate = transferJoinDate;
    }

    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNameFromProject() {
        return nameFromProject;
    }

    public void setNameFromProject(String nameFromProject) {
        this.nameFromProject = nameFromProject;
    }

    public String getNameToProject() {
        return nameToProject;
    }

    public void setNameToProject(String nameToProject) {
        this.nameToProject = nameToProject;
    }

    public String getNameFromDepartment() {
        return nameFromDepartment;
    }

    public void setNameFromDepartment(String nameFromDepartment) {
        this.nameFromDepartment = nameFromDepartment;
    }

    public String getNameToDepartment() {
        return nameToDepartment;
    }

    public void setNameToDepartment(String nameToDepartment) {
        this.nameToDepartment = nameToDepartment;
    }

    public String getNameFromLocation() {
        return nameFromLocation;
    }

    public void setNameFromLocation(String nameFromLocation) {
        this.nameFromLocation = nameFromLocation;
    }

    public String getNameToLocation() {
        return nameToLocation;
    }

    public void setNameToLocation(String nameToLocation) {
        this.nameToLocation = nameToLocation;
    }

    public String getTransferRelivingDate() {
        return transferRelivingDate;
    }

    public void setTransferRelivingDate(String transferRelivingDate) {
        this.transferRelivingDate = transferRelivingDate;
    }

    public String getTransferJoinDate() {
        return transferJoinDate;
    }

    public void setTransferJoinDate(String transferJoinDate) {
        this.transferJoinDate = transferJoinDate;
    }
}
