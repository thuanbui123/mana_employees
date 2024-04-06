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
        projectDAO.insertProjectModel(projectModel);
        return findOneProjectModel(projectModel.getId());
    }

    @Override
    public ProjectModel updateProjectModel(ProjectModel projectModel, int id) {
        if (projectModel.getName() == null && projectModel.getName().isEmpty() || projectModel.getList() == null) {
            return null;
        }
        projectDAO.updateProjectModel(projectModel, id);
        return findOneProjectModel(id);
    }

    @Override
    public void deleteProjectModel(int id) {
        projectDAO.deleteProjectModel(id);
    }
}
