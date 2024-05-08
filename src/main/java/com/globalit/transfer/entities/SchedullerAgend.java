package com.globalit.transfer.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.BitSet;
import java.util.UUID;

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
    private UUID id;

    @Column(name = "originaccount", length = 30, nullable = false)
    private String origingAccount;

    @Column(name = "destinationaccount", length = 30, nullable = false)
    private String destinationAccount;

    @Column(name = "valuetranfer", length = 30, nullable = false)
    private BigDecimal valueTransfer;

    @Column(name = "rate", length = 30, nullable = false)
    private BigDecimal rate;

    @Column(name = "datatransfer", nullable = false)
    private ZonedDateTime dataTransfer;

    @Column(name = "datatoday", nullable = false)
    private ZonedDateTime dateToday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

}
