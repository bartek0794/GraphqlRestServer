package server.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import server.model.Address;
import server.model.Customer;
import server.repository.AddressRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    private AddressRepository addressRepository;

    public CustomerResolver(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddress(Customer customer) {
        return addressRepository.findById(customer.getAddress().getId()).orElse(null);
    }
}
