package server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Component;
import server.model.*;
import server.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;
    private PriorityRepository priorityRepository;
    private ResultRepository resultRepository;
    private StatusRepository statusRepository;
    private CompanyRepository companyRepository;

    public Mutation(AddressRepository addressRepository, CustomerRepository customerRepository,
                 EmployeeRepository employeeRepository, OrderRepository orderRepository, PriorityRepository priorityRepository, ResultRepository resultRepository, StatusRepository statusRepository,
                 CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
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


    public FaultOrder newFaultOrder(String title, Long statusId, Long priorityId, Long customerId, Long employeeId,
                                    String description, String note, Date createDate, Date realizationDate, Date finishDate, Long resultId) {

        FaultOrder faultOrder = new FaultOrder();

        faultOrder.setTitle(title);
        faultOrder.setStatus(new Status(statusId));
        faultOrder.setPriority(new Priority(priorityId));
        faultOrder.setCustomer(new Customer(customerId));
        faultOrder.setEmployee(new Employee(employeeId));
        faultOrder.setDescription(description);
        faultOrder.setNote(note);
        faultOrder.setCreateDate(createDate);
        faultOrder.setRealizationDate(realizationDate);
        faultOrder.setFinishDate(finishDate);
        faultOrder.setResult(new Result(resultId));

        orderRepository.save(faultOrder);

        return faultOrder;
    }

    public Optional<FaultOrder> updateFaultOrder(Long id, String title, Long statusId, Long priorityId, Long customerId, Long employeeId,
                                                 String description, String note, Date createDate, Date realizationDate, Date finishDate, Long resultId) {
        Optional<FaultOrder> faultOrder = orderRepository.findById(id);

        faultOrder.ifPresent(f -> {
            f.setTitle(title);
            f.setStatus(new Status(statusId));
            f.setPriority(new Priority(priorityId));
            f.setCustomer(new Customer(customerId));
            f.setEmployee(new Employee(employeeId));
            f.setDescription(description);
            f.setNote(note);
            f.setCreateDate(createDate);
            f.setRealizationDate(realizationDate);
            f.setFinishDate(finishDate);
            f.setResult(new Result(resultId));
            orderRepository.save(f);
        });

        return faultOrder;
    }

    public boolean deleteFaultOrder() {
        List<Long> faultOrderIds = orderRepository.findFaultOrderIds();
        Integer id = new RandomDataGenerator().nextInt(1, faultOrderIds.size()-1);
        orderRepository.deleteById(faultOrderIds.get(id));

        return true;
    }

}
