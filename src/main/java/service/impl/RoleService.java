package service.impl;

import dao.impl.RoleDAO;

import java.util.List;
import model.RoleModel;
import service.IRoleService;

public class RoleService implements IRoleService {
    private final RoleDAO roleDAO = new RoleDAO();

    @Override
    public List<RoleModel> findAllRoleModel() {
        return roleDAO.findAllRoleModel();
    }

    @Override
    public RoleModel findOneRoleModel(int id) {
        return roleDAO.findOneRoleModel(id);
    }

    @Override
    public RoleModel insertRoleModel(RoleModel roleModel) {
        if (roleModel.getName() == null && roleModel.getName().isEmpty()) {
            return null;
        }
        roleDAO.insertRoleModel(roleModel);
        return roleDAO.findOneRoleModel(roleModel.getId());
    }

    @Override
    public RoleModel updateRoleModel(RoleModel roleModel, int id) {
        if (roleModel.getName() == null && roleModel.getName().isEmpty()) {
            return null;
        }
        roleDAO.updateRoleModel(roleModel, id);
        return roleDAO.findOneRoleModel(roleModel.getId());
    }

    @Override
    public void deleteRoleModel(int id) {
        roleDAO.deleteRoleModel(id);
    }
}
