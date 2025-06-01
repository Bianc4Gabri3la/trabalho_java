package equipe.pastel.clinica_medica.repository;

import equipe.pastel.clinica_medica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}

