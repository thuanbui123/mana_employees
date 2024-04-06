package service;

import model.RoleModel;

import java.util.List;

public interface IRoleService {
    List<RoleModel> findAllRoleModel();

    RoleModel findOneRoleModel(int id);

    RoleModel insertRoleModel(RoleModel roleModel);

    RoleModel updateRoleModel(RoleModel roleModel, int id);

    void deleteRoleModel(int id);
}
