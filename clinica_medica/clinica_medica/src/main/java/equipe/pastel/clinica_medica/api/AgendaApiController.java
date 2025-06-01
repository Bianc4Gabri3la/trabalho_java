package equipe.pastel.clinica_medica.api;

import equipe.pastel.clinica_medica.model.Agenda;
import equipe.pastel.clinica_medica.repository.AgendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaApiController {

    private final AgendaRepository agendaRepository;

    public AgendaApiController(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @GetMapping
    public List<Agenda> listar() {
        return agendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> buscarPorId(@PathVariable Long id) {
        return agendaRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agenda criar(@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizar(@PathVariable Long id, @RequestBody Agenda agendaAtualizada) {
        return agendaRepository.findById(id)
            .map(agenda -> {
                agenda.setMedico(agendaAtualizada.getMedico());
                agenda.setPaciente(agendaAtualizada.getPaciente());
                agenda.setDataHora(agendaAtualizada.getDataHora());
                agendaRepository.save(agenda);
                return ResponseEntity.ok(agenda);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return agendaRepository.findById(id)
            .map(a -> {
                agendaRepository.deleteById(id);
                return ResponseEntity.ok().<Void>build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

