package service;

import model.ProjectModel;

import java.util.List;

public interface IProjectService {
    List<ProjectModel> findAllProjectModel();

    ProjectModel findOneProjectModel(int id);

    ProjectModel insertProjectModel(ProjectModel projectModel);

    ProjectModel updateProjectModel(ProjectModel projectModel, int id);

    void deleteProjectModel(int id);
}
