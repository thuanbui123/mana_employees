package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.RoleModel;

import java.util.List;
public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public List<RoleModel> findAllRoleModel() {
        String sql = "SELECT * FROM role ORDER BY name ASC";
        return query(sql, new RoleMapper());
    }

    @Override
    public RoleModel findOneRoleModel(int id) {
        String sql = "SELECT * FROM role WHERE id = ?";
        if (query(sql, new RoleMapper(), id) != null) {
            return query(sql, new RoleMapper(), id).get(0);
        }
        return null;
    }

    @Override
    public void insertRoleModel(RoleModel roleModel) {
        String sql = "INSERT INTO role (name) VALUES (?)";
        insert(sql, new RoleMapper());
    }

    @Override
    public void updateRoleModel(RoleModel roleModel, int id) {
        String sql = "UPDATE role SET name = ? WHERE id = ?";
        update(sql, new RoleMapper());
    }

    @Override
    public void deleteRoleModel(int id) {
        String sql = "DELETE FROM role WHERE id = ?";
        update(sql, id);
    }

    @Override
    public RoleModel findOneRoleModelByName(String name) {
        String sql = "SELECT * FROM role WHERE name = ?";
        if (query(sql, new RoleMapper(), name) != null) {
            return query(sql, new RoleMapper(), name).get(0);
        }
        return null;
    }
}
