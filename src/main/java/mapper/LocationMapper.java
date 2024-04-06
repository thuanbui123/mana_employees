package mapper;

import model.LocationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements IRowMapper<LocationModel> {
    @Override
    public LocationModel mapRow(ResultSet resultSet) throws SQLException {
        LocationModel locationModel = new LocationModel();
        locationModel.setId(resultSet.getInt("id"));
        locationModel.setName(resultSet.getString("name"));
        return locationModel;
    }
}
