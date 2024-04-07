package service.impl;

import dao.impl.ProjectDAO;
import model.ProjectModel;
import service.IProjectService;

import java.util.List;

public class ProjectService implements IProjectService {

    private final ProjectDAO projectDAO = new ProjectDAO();

    @Override
    public List<ProjectModel> findAllProjectModel() {
        return projectDAO.findAllProjectModel();
    }

    @Override
    public ProjectModel findOneProjectModel(int id) {
        return projectDAO.findOneProjectModel(id);
    }

    @Override
    public ProjectModel insertProjectModel(ProjectModel projectModel) {
        if (projectModel.getName() == null && projectModel.getName().isEmpty() || projectModel.getList() == null) {
            return null;
        }
        return findOneProjectModel((int) projectDAO.insertProjectModel(projectModel));
    }

    @Override
    public ProjectModel updateProjectModel(ProjectModel projectModel, int id) {
        if (projectModel.getName() == null && projectModel.getName().isEmpty() || projectModel.getList() == null) {
            return null;
        }
        projectDAO.deleteMemberToProject(id);
        projectDAO.insertMemberInToProject(id, projectModel.getList());
        projectDAO.updateProjectModel(projectModel, id);
        return findOneProjectModel(id);
    }

    @Override
    public ProjectModel deleteProjectModel(int id) {
        projectDAO.deleteMemberToProject(id);
        projectDAO.deleteProjectModel(id);
        return findOneProjectModel(id);
    }

    @Override
    public List<ProjectModel> searchProject(String query) {
        return projectDAO.searchProject(query);
    }

    @Override
    public ProjectModel updateDoneProject(int id, int status) {
        projectDAO.updateDoneProject(id, status);
        return findOneProjectModel(id);
    }
}
