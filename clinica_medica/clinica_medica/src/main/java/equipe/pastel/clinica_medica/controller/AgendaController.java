package equipe.pastel.clinica_medica.controller;

import equipe.pastel.clinica_medica.service.AgendaService;
import equipe.pastel.clinica_medica.model.Agenda;
import equipe.pastel.clinica_medica.service.MedicoService;
import equipe.pastel.clinica_medica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService agendaService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AgendaController(AgendaService agendaService, MedicoService medicoService, PacienteService pacienteService) {
        this.agendaService = agendaService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agendas", agendaService.listarTodos());
        return "agenda/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("agenda", new Agenda());
        model.addAttribute("medicos", medicoService.listarTodos());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "agenda/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Agenda agenda) {
        agendaService.salvar(agenda);
        return "redirect:/agendas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Agenda agenda = agendaService.buscarPorId(id);
        model.addAttribute("agenda", agenda);
        model.addAttribute("medicos", medicoService.listarTodos());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "agenda/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        agendaService.excluir(id);
        return "redirect:/agendas";
    }
}

