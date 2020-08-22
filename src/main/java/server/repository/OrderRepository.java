package server.repository;

import org.springframework.data.jpa.repository.Query;
import server.model.FaultOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<FaultOrder, Long> {
    @Query("select id from FAULT_ORDER")
    public List<Long> findFaultOrderIds();

}