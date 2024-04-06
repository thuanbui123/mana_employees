package dao.impl;

import dao.IProjectDAO;
import mapper.ProjectMapper;
import model.ProjectModel;

import java.util.List;

public class ProjectDAO extends AbstractDAO<ProjectModel> implements IProjectDAO {
    @Override
    public List<ProjectModel> findAllProjectModel() {
        String sql = "SELECT * FROM employee, department, location, role, project, employeesonproject WHERE project.id = employeesonproject.idProject AND employee.id = employeesonproject.idEmployee AND employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id ORDER BY employee.name ASC";
        return query(sql, new ProjectMapper());
    }

    @Override
    public ProjectModel findOneProjectModel(int id) {
        String sql = "SELECT * FROM employee, department, location, role, project, employeesonproject WHERE project.id = employeesonproject.idProject AND employee.id = employeesonproject.idEmployee AND employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id AND project.id = ?";
        if (query(sql, new ProjectMapper(), id) != null) {
            return query(sql, new ProjectMapper(), id).get(0);
        }
        return null;
    }

    @Override
    public void insertProjectModel(ProjectModel projectModel) {
        String sql = "INSERT INTO project (name, status, created_at, updated_at) VALUES (? , ? , ? , ?)";
        insert(sql, projectModel.getName(), projectModel.isStatus(), projectModel.getCreatedAt(), projectModel.getUpdatedAt());
    }

    @Override
    public void updateProjectModel(ProjectModel projectModel, int id) {
        String sql = "UPDATE project SET name = ?, status = ?, created_at = ?, updated_at = ? WHERE id = ?";
        update(sql, projectModel.getName(), projectModel.isStatus(), projectModel.getCreatedAt(), projectModel.getUpdatedAt(), id);
    }

    @Override
    public void deleteProjectModel(int id) {
        String sql = "DELETE FROM project WHERE id = ?";
        update(sql, id);
    }
}
