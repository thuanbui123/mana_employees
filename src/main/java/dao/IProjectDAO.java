package dao;

import model.ProjectModel;

import java.util.List;

public interface IProjectDAO {

    List<ProjectModel> findAllProjectModel();

    List<ProjectModel> searchProject(String query);

    ProjectModel findOneProjectModel(int id);

    void updateDoneProject(int id, int status);

    long insertProjectModel(ProjectModel projectModel);

    void updateProjectModel(ProjectModel projectModel, int id);

    void deleteProjectModel(int id);
}
