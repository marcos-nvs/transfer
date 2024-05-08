package com.globalit.transfer.repositories;

import com.globalit.transfer.entities.SchedullerAgend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedullerAgendRepository extends JpaRepository<SchedullerAgend, Long> {


    @Query("select s from SchedullerAgend s where s.customer.customerId = ?1 order by s.dataTransfer desc")
    @EntityGraph(attributePaths = {"customer"})
    List<SchedullerAgend> getTransferById(Long customerId);

}
