package model;

public class AbstractModel {
    private int id;

    public AbstractModel() {
    }

    public AbstractModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
