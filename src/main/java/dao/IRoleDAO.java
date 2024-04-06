package dao;


import model.RoleModel;

import java.util.List;

public interface IRoleDAO {
    List<RoleModel> findAllRoleModel();

    RoleModel findOneRoleModel(int id);
    
    RoleModel findOneRoleModelByName(String name);

    void insertRoleModel(RoleModel roleModel);

    void updateRoleModel(RoleModel roleModel, int id);

    void deleteRoleModel(int id);
}
