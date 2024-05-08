package com.globalit.transfer.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.globalit.transfer.dtos.SchedullerDto;
import com.globalit.transfer.service.SchedullerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedullers")
public class SchedullerController {

    @Autowired
    private SchedullerService service;

    @PostMapping
    public ResponseEntity<SchedullerDto> createTransfer(
            @Validated({SchedullerDto.SchedullerView.InsertTransfer.class})
            @RequestBody SchedullerDto scheduller){
        return ResponseEntity.ok().body(service.createTransfer(scheduller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransfer(
            @PathVariable Long id){
        service.deleteTransfer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<SchedullerDto>> getTransfer(
            @PathVariable Long customerId){
        return ResponseEntity.ok().body(service.getTransfer(customerId));
    }


}
