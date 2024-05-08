package com.globalit.transfer.service;

import com.globalit.transfer.dtos.SchedullerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SchedullerService {


    SchedullerDto createTransfer(SchedullerDto scheduller);

    void deleteTransfer(Long id);

    List<SchedullerDto> getTransfer(Long customerId);
}
