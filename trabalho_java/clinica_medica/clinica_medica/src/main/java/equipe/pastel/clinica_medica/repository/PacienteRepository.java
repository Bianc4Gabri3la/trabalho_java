package equipe.pastel.clinica_medica.repository;

import equipe.pastel.clinica_medica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
