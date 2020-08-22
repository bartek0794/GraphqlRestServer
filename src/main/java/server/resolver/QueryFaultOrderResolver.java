package server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import server.model.*;
import server.repository.*;

import java.util.Optional;

@Component
public class QueryFaultOrderResolver implements GraphQLQueryResolver {

    private OrderRepository orderRepository;

    public QueryFaultOrderResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<FaultOrder> faultOrder(Long id) {
        return orderRepository.findById(id);
    }

    public Iterable<FaultOrder> findAllFaultOrders() {
        return orderRepository.findAll();
    }

}






