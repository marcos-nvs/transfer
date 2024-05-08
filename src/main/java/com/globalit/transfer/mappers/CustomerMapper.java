package com.globalit.transfer.mappers;

import com.globalit.transfer.dtos.CustomerDto;
import com.globalit.transfer.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements TransferMapper<CustomerDto, Customer> {

    @Override
    public CustomerDto toDto(Customer entity) {
        return CustomerDto.builder()
                .customerId(entity.getCustomerId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        return Customer.builder()
                .customerId(dto.getCustomerId())
                .name(dto.getName())
                .build();
    }
}
