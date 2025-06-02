package equipe.pastel.clinica_medica.model;

    import jakarta.persistence.*;
    import lombok.Data;
    import java.time.LocalDate;
    import jakarta.validation.constraints.Pattern;

    @Entity
    @Data
    public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome deve conter apenas letras")
        private String nome;

        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos")
        private String cpf;

        private LocalDate dataNascimento;

        private String telefone;
    }
