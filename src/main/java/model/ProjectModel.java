package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProjectModel extends AbstractModel {

    private String name;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private ArrayList<EmployeeModel> list;

    private String members;

    public ProjectModel() {
    }

    public ProjectModel(int status) {

    }

    public ProjectModel(String name, int status, ArrayList<EmployeeModel> list) {
        this.name = name;
        this.status = status;
        this.list = list;
    }

    public ProjectModel(String name, int status, Timestamp createdAt, Timestamp updatedAt, String members, int id) {
        super(id);
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.members = members;
    }

    public ProjectModel(int id, String name, int status, Timestamp createdAt, Timestamp updatedAt, ArrayList<EmployeeModel> list) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "ProjectModel{" + "name=" + name + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", list=" + list + ", members=" + members + '}';
    }

}
