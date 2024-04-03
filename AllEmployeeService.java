import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(String searchTerm, String sortBy) {
        List<Employee> employees;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            employees = employeeRepository.findAll().stream()
                    .filter(employee -> employee.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                    .collect(Collectors.toList());
        } else {
            employees = employeeRepository.findAll();
        }

        if (sortBy != null && !sortBy.isEmpty()) {
            switch (sortBy.toLowerCase()) {
                case "name":
                    employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
                    break;
                
                default:
                    break;
            }
        }

        return employees;
    }
}
