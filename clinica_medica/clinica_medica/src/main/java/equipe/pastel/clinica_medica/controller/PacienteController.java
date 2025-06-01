package equipe.pastel.clinica_medica.controller;

import equipe.pastel.clinica_medica.model.Paciente;
import equipe.pastel.clinica_medica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "templates/paciente/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("templates/paciente", new Paciente());
        return "templates/paciente/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente) {
        pacienteService.salvar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPorId(id);
        model.addAttribute("templates/paciente", paciente);
        return "templates/paciente/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pacienteService.excluir(id);
        return "redirect:/pacientes";
    }
}

