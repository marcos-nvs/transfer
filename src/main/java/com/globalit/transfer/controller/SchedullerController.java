package com.globalit.transfer.controller;

import com.globalit.transfer.dtos.SchedullerDto;
import com.globalit.transfer.service.SchedullerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
