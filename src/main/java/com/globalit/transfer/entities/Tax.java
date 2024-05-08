package com.globalit.transfer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tax")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taxid", nullable = false)
    private UUID taxId;

    @Column(name = "datein", nullable = false)
    private Integer dateIn;

    @Column(name = "dateuntil", nullable = false)
    private Integer dateUntil;


    @Column(name = "valuetax", nullable = false)
    private BigDecimal valueTax;

    @Column(name = "taxpercent", nullable = false)
    private BigDecimal taxPercent;


}
