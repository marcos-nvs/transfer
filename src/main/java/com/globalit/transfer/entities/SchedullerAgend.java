package com.globalit.transfer.entities;


import com.globalit.transfer.enums.SchedullerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedulleragend")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedullerAgend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "originaccount", length = 30, nullable = false)
    private String origingAccount;

    @Column(name = "destinationaccount", length = 30, nullable = false)
    private String destinationAccount;

    @Column(name = "valuetranfer", length = 30, nullable = false)
    private BigDecimal valueTransfer;

    @Column(name = "rate", length = 30, nullable = false)
    private BigDecimal rate;

    @Column(name = "datatransfer", nullable = false)
    private LocalDate dataTransfer;

    @Column(name = "datatoday", nullable = false)
    private LocalDateTime dateToday;

    @Column(name = "status", nullable = false)
    private SchedullerStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    private Customer customer;

}
