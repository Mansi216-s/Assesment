import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeupdateService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            // Update other fields as needed
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
