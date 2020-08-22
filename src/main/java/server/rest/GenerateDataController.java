package server.rest;

import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import server.model.FaultOrder;
import org.springframework.beans.factory.annotation.Autowired;
import server.repository.*;

@RestController
public class GenerateDataController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PriorityRepository priorityRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/generate")
    public void findAllArticles2() {
        for(int i = 1; i < 100000; i++) {
            generateData();
        }
    }

    public void generateData() {
        FaultOrder faultOrder = new FaultOrder();
        faultOrder.setCreateDate(generateDate(new Date(1990, 1,1), new Date(2020,12,31)));
        faultOrder.setRealizationDate(generateDate(new Date(1990, 1,1), new Date(2020,12,31)));
        faultOrder.setFinishDate(generateDate(new Date(1990, 1,1), new Date(2020,12,31)));

        faultOrder.setEmployee(employeeRepository.findById(randLong(1, 1000)).get());
        faultOrder.setCustomer(customerRepository.findById(randLong(1, 1000)).get());
        faultOrder.setTitle("Test title " + randLong(1, 100000));
        faultOrder.setNote("Test note " + randLong(1, 100000));
        faultOrder.setDescription(getDescription() + randLong(1, 100000));
        faultOrder.setPriority(priorityRepository.findById(randLong(1, 5)).get());
        faultOrder.setStatus(statusRepository.findById(randLong(1, 5)).get());
        faultOrder.setResult(resultRepository.findById(randLong(1, 5)).get());

        orderRepository.save(faultOrder);
    }

    public Date generateDate(Date startDate, Date endDate) {
        return new Date();  }

    public Long randLong(long min, long max) {
        Long rand = Math.abs((new java.util.Random().nextLong() % (max - min)) + min);
        if (rand.longValue() == 0) {
            rand = Long.valueOf(1);
        }
        return rand;
    }

    private String getDescription() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tincidunt, turpis vel pretium ornare, " +
                "turpis nibh tempor purus, nec rutrum lacus mauris non metus. " +
                "Pellentesque urna neque, venenatis euismod sem ";
    }
}