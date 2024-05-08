package com.globalit.transfer.repositories;

import com.globalit.transfer.entities.SchedullerAgend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchedullerAgendRepository extends JpaRepository<SchedullerAgend, UUID> {
}
