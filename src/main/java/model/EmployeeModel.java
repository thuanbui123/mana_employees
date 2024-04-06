package model;

public class EmployeeModel extends AbstractModel {

    private String name;
    private String username;
    private String password;
    private DepartmentModel department;
    private LocationModel location;
    private RoleModel role;

    public EmployeeModel() {
    }

    public EmployeeModel(int id, String name, String username, String password, DepartmentModel department, LocationModel location, RoleModel role) {
        super(id);
        this.name = name;
        this.username = username;
        this.password = password;
        this.department = department;
        this.location = location;
        this.role = role;
    }

    public EmployeeModel(String name, String username, String password, DepartmentModel department, LocationModel location, RoleModel role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.department = department;
        this.location = location;
        this.role = role;
    }

    public EmployeeModel(String name, DepartmentModel department, LocationModel location, RoleModel role) {
        this.name = name;
        this.department = department;
        this.location = location;
        this.role = role;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
