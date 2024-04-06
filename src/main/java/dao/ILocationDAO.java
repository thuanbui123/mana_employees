package dao;


import model.LocationModel;

import java.util.List;

public interface ILocationDAO {
    List<LocationModel> findAllLocationModel();

    LocationModel findOneLocationModel(int id);

    LocationModel findOneLocationModelByName(String name);
    
    void insertLocationModel(LocationModel locationModel);

    void updateLocationModel(LocationModel locationModel, int id);

    void deleteLocationModel(int id);

}
