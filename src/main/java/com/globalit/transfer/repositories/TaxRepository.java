package com.globalit.transfer.repositories;

import com.globalit.transfer.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaxRepository extends JpaRepository<Tax, UUID> {
}