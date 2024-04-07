package dao.impl;

import dao.ILocationDAO;
import mapper.LocationMapper;
import model.LocationModel;

import java.util.List;

public class LocationDAO extends AbstractDAO<LocationModel> implements ILocationDAO {
    @Override
    public List<LocationModel> findAllLocationModel() {
        String sql = "SELECT * FROM location ORDER BY name ASC";
        return query(sql, new LocationMapper());
    }

    @Override
    public LocationModel findOneLocationModel(int id) {
        String sql = "SELECT * FROM location WHERE id = ?";
        if (query(sql, new LocationMapper(), id) != null) {
            return query(sql, new LocationMapper(), id).get(0);
        }
        return null;
    }

    @Override
    public long insertLocationModel(LocationModel locationModel) {
        String sql = "INSERT INTO location (name) VALUES (?)";
        return insert(sql, locationModel.getName());
    }

    @Override
    public void updateLocationModel(LocationModel locationModel, int id) {
        String sql = "UPDATE location SET name = ? WHERE id = ?";
        update(sql, locationModel.getName(), id);
    }
    @Override
    public void deleteLocationModel(int id) {
        String sql = "DELETE FROM location WHERE id = ?";
        update(sql, id);
    }

    @Override
    public LocationModel findOneLocationModelByName(String name) {
        String sql = "SELECT * FROM location WHERE name = ?";
        if (query(sql, new LocationMapper(), name) != null) {
            return query(sql, new LocationMapper(), name).get(0);
        }
        return null;
    }
}
