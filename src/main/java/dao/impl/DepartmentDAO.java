package dao.impl;

import dao.IDepartmentDAO;
import mapper.DepartmentMapper;
import model.DepartmentModel;

import java.util.List;

public class DepartmentDAO extends AbstractDAO<DepartmentModel> implements IDepartmentDAO {
    @Override
    public List<DepartmentModel> findAllDepartment() {
        String sql = "SELECT * FROM department ORDER BY name ASC";
        return query(sql, new DepartmentMapper());
    }

    @Override
    public DepartmentModel findOneDepartment(int id) {
        String sql = "SELECT * FROM department WHERE id = ?";
        if (query(sql, new DepartmentMapper(), id) != null) {
            return query(sql, new DepartmentMapper(), id).get(0);
        }
        return null;
    }

    @Override
    public void insertDepartment(DepartmentModel departmentModel) {
        String sql = "INSERT INTO department (name) VALUES (?)";
        insert(sql, departmentModel.getName());
    }

    @Override
    public void updateDepartment(DepartmentModel departmentModel, int id) {
        String sql = "UPDATE department SET name = ? WHERE id = ?";
        update(sql, departmentModel.getName(), id);
    }

    @Override
    public void deleteDepartment(int id) {
        String sql = "DELETE FROM department WHERE id = ?";
        update(sql, id);
    }

    @Override
    public DepartmentModel findOneDepartmentByName(String name) {
        String sql = "SELECT * FROM department WHERE name = ?";
        if (query(sql, new DepartmentMapper(), name) != null) {
            return query(sql, new DepartmentMapper(), name).get(0);
        }
        return null;
    }
}
