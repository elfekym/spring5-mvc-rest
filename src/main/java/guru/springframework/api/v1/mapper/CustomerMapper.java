package guru.springframework.api.v1.mapper;

import guru.springframework.Domain.Customer;
import guru.springframework.api.v1.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    CustomerDTO customerToCustomerDTO(Customer customer);
}
