package com.globalit.transfer.service;

import com.globalit.transfer.dtos.SchedullerDto;
import com.globalit.transfer.entities.SchedullerAgend;
import com.globalit.transfer.entities.Tax;
import com.globalit.transfer.enums.SchedullerStatus;
import com.globalit.transfer.exceptions.TransferConflictException;
import com.globalit.transfer.exceptions.TransferNotFoundException;
import com.globalit.transfer.mappers.SchedullerMapper;
import com.globalit.transfer.repositories.CustomerRepository;
import com.globalit.transfer.repositories.SchedullerAgendRepository;
import com.globalit.transfer.repositories.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedullerServiceImpl implements SchedullerService {

    @Autowired
    private SchedullerAgendRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private SchedullerMapper mapper;

    @Override
    public SchedullerDto createTransfer(SchedullerDto scheduller) {

        var customer = customerRepository.findById(scheduller.getCustomerId()).orElseThrow(() -> new TransferNotFoundException("Cliente Não encontrado!!!!"));
        List<Tax> tax = taxRepository.findAll();

        var schedullerAgend = mapper.toEntity(scheduller);
        schedullerAgend.setCustomer(customer);
        schedullerAgend.setDateToday(LocalDateTime.now());
        schedullerAgend.setRate(calculetedRate(schedullerAgend, tax));
        schedullerAgend.setStatus(SchedullerStatus.AGENDADO);
        schedullerAgend = repository.save(schedullerAgend);

        return mapper.toDto(schedullerAgend);
    }

    @Override
    public void deleteTransfer(Long id) {

        var scheduller = repository.findById(id).orElseThrow(() -> new TransferNotFoundException("Número de Transferência não encontrado"));
        scheduller.setStatus(SchedullerStatus.CANCELADO);

        repository.save(scheduller);
    }

    @Override
    public List<SchedullerDto> getTransfer(Long customerId) {
        return repository.getTransferById(customerId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    private BigDecimal calculetedRate(SchedullerAgend schedullerAgend, List<Tax> tax) {

        long dias = LocalDate.now().until(schedullerAgend.getDataTransfer(), ChronoUnit.DAYS);

        var taxRate = tax.stream().filter(rate -> dias >= rate.getDateIn() && dias <= rate.getDateUntil()).findFirst();

        if (taxRate.isEmpty()) {
            throw new TransferConflictException("Não foi possível calcular a taxa. Tabela de taxa não encontrada");
        }

        BigDecimal valuePercent = BigDecimal.ZERO;

        if (taxRate.get().getTaxPercent().doubleValue() > 0) {
            valuePercent = schedullerAgend.getValueTransfer().multiply(taxRate.get().getTaxPercent()).divide(new BigDecimal(100));
        }

        BigDecimal valueTax = taxRate.get().getValueTax();

        return valueTax.add(valuePercent);


    }

}
