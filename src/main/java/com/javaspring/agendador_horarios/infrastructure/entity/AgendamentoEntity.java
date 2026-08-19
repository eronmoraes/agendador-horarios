package com.javaspring.agendador_horarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private String profissional;
    private String cliente;
    private String telefone;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataInsercao = LocalDateTime.now();
}
