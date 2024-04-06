package model;

public class LocationModel extends AbstractModel{

    private String name;

    public LocationModel() {};
    public LocationModel(int id, String name) {
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
