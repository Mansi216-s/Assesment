import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
