package equipe.pastel.clinica_medica.repository;

import equipe.pastel.clinica_medica.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
