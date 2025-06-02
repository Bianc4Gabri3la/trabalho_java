package equipe.pastel.clinica_medica.service;

import equipe.pastel.clinica_medica.model.Paciente;
import equipe.pastel.clinica_medica.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public void salvar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }
}

