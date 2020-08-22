package server.rest;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import server.model.*;
import server.repository.OrderRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/findAllOrders")
    public Iterable<FaultOrder> findAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/order")
    public Optional<FaultOrder> order(@RequestParam(value = "id") Long id) {
        return orderRepository.findById(id);
    }

    @RequestMapping(value="/createFaultOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    FaultOrder createFaultOrder(@RequestBody FaultOrder newFaultOrder) {
        return orderRepository.save(newFaultOrder);
    }

    @DeleteMapping("/deleteOrder")
    public boolean deleteOrder() {
        List<Long> faultOrderIds = orderRepository.findFaultOrderIds();
        Integer id = new RandomDataGenerator().nextInt(1, faultOrderIds.size()-1);
        orderRepository.deleteById(faultOrderIds.get(id));
        return true;
    }

    @PutMapping("/updateFaultOrder")
    Optional<FaultOrder> updateFaultOrder(@RequestParam(value = "id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "statusId") Long statusId, @RequestParam(value = "priorityId") Long priorityId,
                                          @RequestParam(value = "customerId") Long customerId, @RequestParam(value = "employeeId") Long employeeId,
                                          @RequestParam(value = "description") String description, @RequestParam(value = "note") String note, @RequestParam(value = "createDate") String createDate,
                                          @RequestParam(value = "realizationDate") String realizationDate, @RequestParam(value = "finishDate") String finishDate, @RequestParam(value = "resultId") Long resultId) {
        Optional<FaultOrder> faultOrder = orderRepository.findById(id);

                faultOrder.ifPresent(f -> {
                    f.setTitle(title);
                    f.setStatus(new Status(statusId));
                    f.setPriority(new Priority(priorityId));
                    f.setCustomer(new Customer(customerId));
                    f.setEmployee(new Employee(employeeId));
                    f.setDescription(description);
                    f.setNote(note);
                    f.setCreateDate(new Date());
                    f.setRealizationDate(new Date());
                    f.setFinishDate(new Date());
                    f.setResult(new Result(resultId));
                     orderRepository.save(f);
                });
        return faultOrder;

    }








}