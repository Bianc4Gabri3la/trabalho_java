package equipe.pastel.clinica_medica.controller;


import equipe.pastel.clinica_medica.model.Medico;
import equipe.pastel.clinica_medica.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("medicos", medicoService.listarTodos());
        return "medico/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico) {
        medicoService.salvar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Medico medico = medicoService.buscarPorId(id);
        model.addAttribute("medico", medico);
        return "medico/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        medicoService.excluir(id);
        return "redirect:/medicos";
    }
}
