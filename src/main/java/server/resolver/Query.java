package server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import server.model.*;
import server.repository.*;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private PriorityRepository priorityRepository;
    private ResultRepository resultRepository;
    private StatusRepository statusRepository;
    private CompanyRepository companyRepository;

    public Query(AddressRepository addressRepository, CustomerRepository customerRepository,
                 EmployeeRepository employeeRepository, PriorityRepository priorityRepository, ResultRepository resultRepository, StatusRepository statusRepository,
                 CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.priorityRepository = priorityRepository;
        this.resultRepository = resultRepository;
        this.statusRepository = statusRepository;
        this.companyRepository = companyRepository;
    }

    public Optional<Address> address(Long id) {
        return addressRepository.findById(id);
    }

    public Iterable<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Customer> customer(Long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Employee> employee(Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Priority> priority(Long id) {
        return priorityRepository.findById(id);
    }

    public Iterable<Priority> findAllPriorities() {
        return priorityRepository.findAll();
    }

    public Optional<Result> result(Long id) {
        return resultRepository.findById(id);
    }

    public Iterable<Result> findAllResults() {
        return resultRepository.findAll();
    }

    public Optional<Status> status(Long id) {
        return statusRepository.findById(id);
    }

    public Iterable<Status> findAllStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Company> company(Long id) {
        return companyRepository.findById(id);
    }

    public Iterable<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

}