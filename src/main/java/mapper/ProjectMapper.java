package mapper;

import model.EmployeeModel;
import model.ProjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProjectMapper implements IRowMapper<ProjectModel> {
    private final Set<Integer> processedProjectIds = new HashSet<>();
    private final Map<Integer, ProjectModel> projectsById = new HashMap<>();

    @Override
    public ProjectModel mapRow(ResultSet resultSet) throws SQLException {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        ProjectModel projectModel = new ProjectModel();
        EmployeeModel employeeModel = employeeMapper.mapRow(resultSet);

        ArrayList<EmployeeModel> employees = new ArrayList<>();

        int projectId = resultSet.getInt(15);

        if (processedProjectIds.contains(projectId)) {
            projectsById.get(projectId).getList().add(employeeModel);
            return null;
        } else {
            processedProjectIds.add(projectId);

            projectModel.setId(projectId);
            projectModel.setName(resultSet.getString(16));
            projectModel.setStatus(resultSet.getInt(17));
            projectModel.setCreatedAt(resultSet.getTimestamp(18));
            projectModel.setUpdatedAt(resultSet.getTimestamp(19));

            projectsById.put(projectId, projectModel);
            employees.add(employeeModel);
            projectModel.setList(employees);
        }

        return projectModel;
    }
}
