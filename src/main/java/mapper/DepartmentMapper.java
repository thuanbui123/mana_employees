package mapper;

import model.DepartmentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements IRowMapper<DepartmentModel>{
    @Override
    public DepartmentModel mapRow(ResultSet resultSet) throws SQLException {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setId(resultSet.getInt("id"));
        departmentModel.setName(resultSet.getString("name"));
        return departmentModel;
    }
}
