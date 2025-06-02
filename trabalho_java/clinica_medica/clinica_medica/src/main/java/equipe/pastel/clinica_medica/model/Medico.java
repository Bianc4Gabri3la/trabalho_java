package equipe.pastel.clinica_medica.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

@Entity
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome deve conter apenas letras")
    private String nome;

    private String crm;
    private String especialidade;
}
