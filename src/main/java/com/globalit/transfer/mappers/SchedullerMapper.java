package com.globalit.transfer.mappers;

import com.globalit.transfer.dtos.SchedullerDto;
import com.globalit.transfer.entities.SchedullerAgend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedullerMapper implements TransferMapper<SchedullerDto, SchedullerAgend> {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public SchedullerDto toDto(SchedullerAgend entity) {
        return SchedullerDto.builder()
                .id(entity.getId())
                .rate(entity.getRate())
                .customer(entity.getCustomer() != null ? customerMapper.toDto(entity.getCustomer()): null)
                .dataTransfer(entity.getDataTransfer())
                .dateToday(entity.getDateToday())
                .valueTransfer(entity.getValueTransfer())
                .destinationAccount(entity.getDestinationAccount())
                .origingAccount(entity.getOrigingAccount())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public SchedullerAgend toEntity(SchedullerDto dto) {
        return SchedullerAgend.builder()
                .id(dto.getId())
                .rate(dto.getRate())
                .origingAccount(dto.getOrigingAccount())
                .dataTransfer(dto.getDataTransfer())
                .destinationAccount(dto.getDestinationAccount())
                .customer(dto.getCustomer() != null ? customerMapper.toEntity(dto.getCustomer()): null)
                .dateToday(dto.getDateToday())
                .valueTransfer(dto.getValueTransfer())
                .build();
    }
}
