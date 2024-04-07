package service;

import model.LocationModel;

import java.util.List;

public interface ILocationService {
    List<LocationModel> findAllLocationModel();

    LocationModel findOneLocationModel(int id);

    long insertLocationModel(LocationModel locationModel);

    LocationModel updateLocationModel(LocationModel locationModel, int id);

    void deleteLocationModel(int id);
}
