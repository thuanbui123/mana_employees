package service.impl;

import dao.impl.DepartmentDAO;
import model.DepartmentModel;
import service.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    public List<DepartmentModel> findAllDepartment() {
        return departmentDAO.findAllDepartment();
    }

    @Override
    public DepartmentModel findOneDepartment(int id) {
        return departmentDAO.findOneDepartment(id);
    }

    @Override
    public DepartmentModel insertDepartment(DepartmentModel departmentModel) {
        if (departmentModel.getName() == null && departmentModel.getName().isEmpty()) {
            return null;
        }
        departmentDAO.insertDepartment(departmentModel);
        return departmentDAO.findOneDepartment(departmentModel.getId());
    }

    @Override
    public DepartmentModel updateDepartment(DepartmentModel departmentModel, int id) {
        if (departmentModel.getName() == null && departmentModel.getName().isEmpty()) {
            return null;
        }
        departmentDAO.updateDepartment(departmentModel, id);
        return findOneDepartment(departmentModel.getId());
    }

    @Override
    public void deleteDepartment(int id) {
        departmentDAO.deleteDepartment(id);
    }
}
