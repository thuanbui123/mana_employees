package mapper;

import model.DepartmentModel;
import model.EmployeeModel;
import model.LocationModel;
import model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements IRowMapper<EmployeeModel> {
    @Override
    public EmployeeModel mapRow(ResultSet resultSet) throws SQLException {
        EmployeeModel employeeModel = new EmployeeModel();
        DepartmentModel departmentModel = new DepartmentModel();
        LocationModel locationModel = new LocationModel();
        RoleModel roleModel = new RoleModel();

        employeeModel.setId(resultSet.getInt(1));
        employeeModel.setName(resultSet.getString(2));
        employeeModel.setUsername(resultSet.getString(3));
        employeeModel.setPassword(resultSet.getString(4));
        departmentModel.setId(resultSet.getInt(5));
        departmentModel.setName(resultSet.getString(10));
        employeeModel.setDepartment(departmentModel);

        locationModel.setId(resultSet.getInt(6));
        locationModel.setName(resultSet.getString(12));
        employeeModel.setLocation(locationModel);

        roleModel.setId(resultSet.getInt(7));
        roleModel.setName(resultSet.getString(14));
        employeeModel.setRole(roleModel);
        return employeeModel;
    }
}
