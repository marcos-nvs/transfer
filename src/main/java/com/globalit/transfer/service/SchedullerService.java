package com.globalit.transfer.service;

import com.globalit.transfer.dtos.SchedullerDto;

import java.util.List;

public interface SchedullerService {


    SchedullerDto createTransfer(SchedullerDto scheduller);

    void deleteTransfer(Long id);

    List<SchedullerDto> getTransfer(Long customerId);
}
