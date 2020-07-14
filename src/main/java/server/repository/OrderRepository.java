package server.repository;

import server.model.FaultOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<FaultOrder, Long> { }
