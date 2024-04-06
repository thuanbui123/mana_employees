package dao;


import model.ProjectModel;

import java.util.List;

public interface IProjectDAO {
    List<ProjectModel> findAllProjectModel();

    ProjectModel findOneProjectModel(int id);

    void insertProjectModel(ProjectModel projectModel);

    void updateProjectModel(ProjectModel projectModel, int id);

    void deleteProjectModel(int id);
}
