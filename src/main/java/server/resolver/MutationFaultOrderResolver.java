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
public class MutationFaultOrderResolver implements GraphQLMutationResolver {

    private OrderRepository orderRepository;

    public MutationFaultOrderResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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