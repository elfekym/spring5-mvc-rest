package guru.springframework.services;

import guru.springframework.Domain.Customer;
import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Max";
    public static final long ID = 2L;
    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl( customerRepository, CustomerMapper.INSTANCE);
    }


    @Test
    public void getAllCustomers() {

        List<Customer> categories = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(categories);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerById() {
        Customer customer1 = new Customer();
        customer1.setId(ID);
        customer1.setFirstName(FIRST_NAME);
        customer1.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals(FIRST_NAME, customerDTO.getFirstName());
    }
}