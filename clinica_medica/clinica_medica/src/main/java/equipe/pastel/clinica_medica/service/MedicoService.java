package equipe.pastel.clinica_medica.service;

import equipe.pastel.clinica_medica.model.Medico;
import equipe.pastel.clinica_medica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public void salvar(Medico medico) {
        medicoRepository.save(medico);
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }
}

