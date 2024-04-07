package service;

import model.ProjectModel;

import java.util.List;

public interface IProjectService {

    List<ProjectModel> findAllProjectModel();

    List<ProjectModel> searchProject(String query);

    ProjectModel findOneProjectModel(int id);

    ProjectModel insertProjectModel(ProjectModel projectModel);

    ProjectModel updateDoneProject(int id, int status);

    ProjectModel updateProjectModel(ProjectModel projectModel, int id);

    ProjectModel deleteProjectModel(int id);
}
