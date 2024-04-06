package model;

public class DepartmentModel extends AbstractModel {
    private String name;

    public DepartmentModel() {
    }

    public DepartmentModel(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
