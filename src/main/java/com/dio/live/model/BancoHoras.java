package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BancoHoras implements Serializable {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasId implements Serializable {
        private long idBancoHoras;
        private long idMovimento;
        private long idUsuario;
    }
    @EmbeddedId
    private BancoHorasId id;
    @Column
    private LocalDateTime dataTrabalhada;
    @Column
    private BigDecimal quantidadeHoras;
    @Column
    private BigDecimal saldo;
}
