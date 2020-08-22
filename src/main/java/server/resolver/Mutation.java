package server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import server.model.*;
import server.repository.*;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private PriorityRepository priorityRepository;
    private ResultRepository resultRepository;
    private StatusRepository statusRepository;
    private CompanyRepository companyRepository;

    public Mutation(AddressRepository addressRepository, CustomerRepository customerRepository,
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

    public Address newAddress(String city, String street, String streetNumber, String homeNumber) {
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setStreetNumber(streetNumber);
        address.setHomeNumber(homeNumber);

        addressRepository.save(address);

        return address;
    }

    public Optional<Address> updateAddress(Long id, String city, String street, String streetNumber, String homeNumber) {
        Optional<Address> address = addressRepository.findById(id);

        address.ifPresent(a -> {
            a.setCity(city);
            a.setStreet(street);
            a.setStreetNumber(streetNumber);
            a.setHomeNumber(homeNumber);
            addressRepository.save(a);
        });

        return address;
    }

    public boolean deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return true;
    }

    public Company newCompany(String name) {
        Company company = new Company();
        company.setName(name);

        companyRepository.save(company);

        return company;
    }

    public Optional<Company> updateCompany(Long id, String name) {
        Optional<Company> company = companyRepository.findById(id);

        company.ifPresent(c -> {
            c.setName(name);
            companyRepository.save(c);
        });

        return company;
    }

    public boolean deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return true;
    }

    public Priority newPriority(String name) {
        Priority priority = new Priority();
        priority.setName(name);

        priorityRepository.save(priority);

        return priority;
    }

    public Optional<Priority> updatePriority(Long id, String name) {
        Optional<Priority> priority = priorityRepository.findById(id);

        priority.ifPresent(p -> {
            p.setName(name);
            priorityRepository.save(p);
        });

        return priority;
    }

    public boolean deletePriority(Long id) {
        priorityRepository.deleteById(id);
        return true;
    }

    public Result newResult(String name) {
        Result result = new Result();
        result.setName(name);

        resultRepository.save(result);

        return result;
    }

    public Optional<Result> updateResult(Long id, String name) {
        Optional<Result> result = resultRepository.findById(id);

        result.ifPresent(r -> {
            r.setName(name);
            resultRepository.save(r);
        });

        return result;
    }

    public boolean deleteResult(Long id) {
        resultRepository.deleteById(id);
        return true;
    }

    public Status newStatus(String name) {
        Status status = new Status();
        status.setName(name);

        statusRepository.save(status);

        return status;
    }

    public Optional<Status> updateStatus(Long id, String name) {
        Optional<Status> status = statusRepository.findById(id);

        status.ifPresent(s -> {
            s.setName(name);
            statusRepository.save(s);
        });

        return status;
    }

    public boolean deleteStatus(Long id) {
        statusRepository.deleteById(id);
        return true;
    }


    public Customer newCustomer(String firstName, String lastName, String phoneNumber,
                                String email, Long addressId) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setAddress(new Address(addressId));

        customerRepository.save(customer);

        return customer;
    }

    public Optional<Customer> updateCustomer(Long id, String firstName, String lastName, String phoneNumber,
                                             String email, Long addressId) {
        Optional<Customer> customer = customerRepository.findById(id);

        customer.ifPresent(c -> {
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPhoneNumber(phoneNumber);
            c.setEmail(email);
            c.setAddress(new Address(addressId));
            customerRepository.save(c);
        });

        return customer;
    }

    public boolean deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return true;
    }


    public Employee newEmployee(String firstName, String lastName, String phoneNumber,
                                     String email, Long companyId) {

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        employee.setCompany(new Company(companyId));

        employeeRepository.save(employee);

        return employee;
    }

    public Optional<Employee> updateEmployee(Long id, String firstName, String lastName, String phoneNumber,
                                             String email, Long companyId) {
        Optional<Employee> employee = employeeRepository.findById(id);

        employee.ifPresent(e -> {
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setPhoneNumber(phoneNumber);
            e.setEmail(email);
            e.setCompany(new Company(companyId));
            employeeRepository.save(e);
        });

        return employee;
    }

    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }


}
