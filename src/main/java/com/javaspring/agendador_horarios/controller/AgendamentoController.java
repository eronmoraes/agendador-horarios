package com.javaspring.agendador_horarios.controller;

import com.javaspring.agendador_horarios.infrastructure.entity.AgendamentoEntity;
import com.javaspring.agendador_horarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoEntity> saveAgendamento(@RequestBody AgendamentoEntity agendamento) {

        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAgendamento(@RequestParam String cliente,
                                                  @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoEntity>> findAllAgendamentos(@RequestParam LocalDate data) {

        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping
    public ResponseEntity<AgendamentoEntity> updateAgendamento(@RequestBody AgendamentoEntity agendamento,
                                                               @RequestParam String cliente,
                                                               @RequestParam LocalDateTime dataHoraAgendamento) {
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }
}
