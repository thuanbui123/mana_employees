package mapper;

import model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements IRowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet resultSet) throws SQLException {
        RoleModel roleModel = new RoleModel();
        roleModel.setId(resultSet.getInt("id"));
        roleModel.setName(resultSet.getString("name"));
        return roleModel;
    }
}
