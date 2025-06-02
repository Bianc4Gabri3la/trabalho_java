package equipe.pastel.clinica_medica.service;

import equipe.pastel.clinica_medica.model.Agenda;
import equipe.pastel.clinica_medica.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    public void salvar(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    public Agenda buscarPorId(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        agendaRepository.deleteById(id);
    }
}

