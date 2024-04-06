package model;

public class RoleModel extends AbstractModel {

    private String name;

    public RoleModel() {
    }

    public RoleModel(int id, String name) {
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
