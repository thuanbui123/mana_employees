package model;


import java.sql.Timestamp;
import java.util.ArrayList;

public class ProjectModel extends AbstractModel{

    private String name;
    private boolean status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private ArrayList<EmployeeModel> list;

    public ProjectModel() {};
    public ProjectModel(int id, String name, boolean status, Timestamp createdAt, Timestamp updatedAt, ArrayList<EmployeeModel> list) {
        super(id);
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ArrayList<EmployeeModel> getList() {
        return list;
    }

    public void setList(ArrayList<EmployeeModel> list) {
        this.list = list;
    }
}
