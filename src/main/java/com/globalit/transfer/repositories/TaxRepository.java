package com.globalit.transfer.repositories;

import com.globalit.transfer.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
