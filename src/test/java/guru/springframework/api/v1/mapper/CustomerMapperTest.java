package guru.springframework.api.v1.mapper;

import guru.springframework.Domain.Customer;
import guru.springframework.api.v1.model.CustomerDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Max";
    public static final long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Test
    public void customerToCustomerDTO() {
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(ID);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }
}