package service.impl;

import dao.impl.LocationDAO;
import model.LocationModel;
import service.ILocationService;

import java.util.List;

public class LocationService implements ILocationService {
    private final LocationDAO locationDAO = new LocationDAO();
    @Override
    public List<LocationModel> findAllLocationModel() {

        return locationDAO.findAllLocationModel();
    }

    @Override
    public LocationModel findOneLocationModel(int id) {
        return locationDAO.findOneLocationModel(id);
    }

    @Override
    public long insertLocationModel(LocationModel locationModel) {
        if (locationModel.getName() == null && locationModel.getName().isEmpty()) {
            return 0;
        }

        return locationDAO.insertLocationModel(locationModel);
    }

    @Override
    public LocationModel updateLocationModel(LocationModel locationModel, int id) {
        if (locationModel.getName() == null && locationModel.getName().isEmpty()) {
            return null;
        }
        locationDAO.updateLocationModel(locationModel, id);
        return locationDAO.findOneLocationModel(id);
    }

    @Override
    public void deleteLocationModel(int id) {
        locationDAO.deleteLocationModel(id);
    }
}
