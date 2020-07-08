package ec.edu.utpl.app.gstnmedicos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.edu.utpl.app.gstnmedicos.models.entity.Medico;
import ec.edu.utpl.app.gstnmedicos.models.services.MedicoServiceImpl;

@Controller
public class MedicoController {

	@Autowired
	private MedicoServiceImpl medicoService;

	/* -------------- Crear Médico -------------- */

	@RequestMapping("/crear_medico")
	public String crearPersonal(Model model) {
		Medico medico = new Medico();
		model.addAttribute("medico", medico);

		return "medico/crear_medico";
	}

	/* -------------- Listar Médico -------------- */

	@RequestMapping("/listar_medico")
	public String listarPersonal(Model model) {
		List<Medico> listMedico = medicoService.listAll();
		model.addAttribute("listMedico", listMedico);

		return "medico/listar_medico";
	}

	/* -------------- Guardar Médico -------------- */

	@RequestMapping(value = "/guardar_medico", method = RequestMethod.POST)
	public String guardarMedico(@ModelAttribute("medico") Medico medico) {

		medicoService.save(medico);
		return "redirect:/medico/listar_medico";
	}

	/* -------------- Editar Médico -------------- */

	@RequestMapping(value = "/editar_medico/{id_medico}")
	public String editarMedico(@PathVariable(value = "id_medico") long id_medico, Map<String, Object> model) {

		Medico medico = null;

		if (id_medico > 0) {
			medico = medicoService.get(id_medico);
			if (medico == null) {
				return "redirect:/personal//listar_personal";
			}
		} else {
			return "redirect:/personal/listar_personal";
		}

		model.put("medico", medico);

		return "medico/editar_medico";
	}

	/* -------------- Eliminar Médico -------------- */

	@RequestMapping("/eliminar_medico/{id_medico}")
	public String eliminarMedico(@PathVariable(name = "id_medico") long id_medico) {

		if (id_medico > 0) {
			medicoService.delete(id_medico);
		}
		return "redirect:/medico/listar_medico";
	}

}
