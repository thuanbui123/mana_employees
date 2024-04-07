package dao.impl;

import dao.IProjectDAO;
import java.util.ArrayList;
import mapper.ProjectMapper;
import model.ProjectModel;

import java.util.List;
import model.EmployeeModel;

public class ProjectDAO extends AbstractDAO<ProjectModel> implements IProjectDAO {

    @Override
    public List<ProjectModel> findAllProjectModel() {
        String sql = "SELECT * FROM employee, department, location, role, project, employeesonproject WHERE project.id = employeesonproject.idProject AND employee.id = employeesonproject.idEmployee AND employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id ORDER BY employee.name ASC";
        return query(sql, new ProjectMapper());
    }

    @Override
    public ProjectModel findOneProjectModel(int id) {
        String sql = "SELECT * FROM employee, department, location, role, project, employeesonproject WHERE project.id = employeesonproject.idProject AND employee.id = employeesonproject.idEmployee AND employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id AND project.id = ?";
        if (query(sql, new ProjectMapper(), id) != null && !query(sql, new ProjectMapper(), id).isEmpty()) {
            return query(sql, new ProjectMapper(), id).get(0);
        }
        return null;
    }

    @Override
    public long insertProjectModel(ProjectModel projectModel) {
        String sql = "INSERT INTO project (name, status) VALUES ( ?, ?)";
        long id = insert(sql, projectModel.getName(), projectModel.getStatus());
        insertMemberInToProject(id, projectModel.getList());
        return id;
    }

    public void insertMemberInToProject(long id, ArrayList<EmployeeModel> list) {
        String sql = "INSERT INTO employeesonproject (idEmployee, idProject) VALUES (? , ?)";
        for (EmployeeModel employeeModel : list) {
            insert(sql, employeeModel.getId(), id);
        }
    }

    @Override
    public void updateProjectModel(ProjectModel projectModel, int id) {
        String sql = "UPDATE project SET name = ?, status = ? WHERE id = ?";
        update(sql, projectModel.getName(), projectModel.getStatus(), id);
    }

    public void deleteMemberToProject(int id) {
        String sql = "DELETE from employeesonproject WHERE idProject = ?";
        update(sql, id);
    }

    @Override
    public void deleteProjectModel(int id) {
        String sql = "DELETE FROM project WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<ProjectModel> searchProject(String query) {
        String sql = "SELECT * FROM employee, department, location, role, project, employeesonproject WHERE project.id = employeesonproject.idProject AND employee.id = employeesonproject.idEmployee AND employee.departmentId = department.id AND employee.locationId = location.id AND employee.roleId = role.id AND project.name LIKE '%" + query + "%' ORDER BY employee.name ASC";
        return query(sql, new ProjectMapper());
    }

    @Override
    public void updateDoneProject(int id, int status) {
        String sql = "UPDATE project SET status = " + status + " WHERE id = " + id;
        update(sql);
    }

}
