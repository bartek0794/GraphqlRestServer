package server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.model.Employee;

import java.util.Optional;

@RestController
public class EmployeeRepository {

    @Autowired
    private server.repository.EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public Optional<Employee> employee(@RequestParam(value = "id") Long id) {
        return employeeRepository.findById(id);
    }
}

