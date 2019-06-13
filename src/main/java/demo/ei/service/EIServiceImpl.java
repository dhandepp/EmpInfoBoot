package demo.ei.service;

import demo.ei.dao.EmployeeRepo;
import demo.ei.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EIServiceImpl {

    @Autowired
    EmployeeRepo repo;

    public List<Employee> find() {
        return repo.findAll();
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public Employee retrieve(String id) {
        return repo.findById(id).get();
    }

    public Employee update(Employee employee, String id) throws Exception {
        return repo.findById(id).map(employee1 -> {
            if (employee.getName() != null)
                employee1.setName(employee.getName());
            if (employee.getId() != null)
                employee1.setId(employee.getId());
            if (employee.getPractice() != null)
                employee1.setPractice(employee.getPractice());
            if (employee.getProject() != null)
                employee1.setProject(employee.getProject());
            return repo.save(employee1);
        }).orElseThrow(() -> new Exception("Employee Not found with Id " + id));
    }

    public ResponseEntity<?> delete(String id) throws Exception {
        return repo.findById(id).map(employee -> {
            repo.delete(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Employee Not found with Id " + id));
    }
}
