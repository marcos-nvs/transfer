package com.globalit.transfer.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.globalit.transfer.enums.SchedullerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedullerDto {

    public interface SchedullerView {

        interface InsertTransfer {
        }

        interface UpdateTransfer {
        }
    }

    @JsonView({SchedullerView.UpdateTransfer.class})
    @NotNull(groups = {SchedullerView.UpdateTransfer.class}, message = "Id de transferência é obrigatório!!")
    private Long id;

    @JsonView({SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class})
    @NotNull(groups = {SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class}, message = "Conta origem é obrigatório!!")
    private String origingAccount;

    @JsonView({SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class})
    @NotNull(groups = {SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class}, message = "Conta destino é obrigatório!!")
    private String destinationAccount;

    @JsonView({SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class})
    @NotNull(groups = {SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class}, message = "Valor da Transferência é obrigatório!!")
    private BigDecimal valueTransfer;

    private BigDecimal rate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView({SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class})
    @NotNull(groups = {SchedullerView.InsertTransfer.class, SchedullerView.UpdateTransfer.class}, message = "Data da Transferência é obrigatório!!")
    private LocalDate dataTransfer;

    private SchedullerStatus status;

    private LocalDateTime dateToday;

    private CustomerDto customer;

    @JsonView({SchedullerView.InsertTransfer.class})
    @NotNull(groups = {SchedullerView.InsertTransfer.class}, message = "Cliente é obrigatório!!")
    private Long customerId;

}
