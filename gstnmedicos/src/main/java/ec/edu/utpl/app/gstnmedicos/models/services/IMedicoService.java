package ec.edu.utpl.app.gstnmedicos.models.services;

import java.util.List;

import ec.edu.utpl.app.gstnmedicos.models.entity.Medico;

public interface IMedicoService {

	public List<Medico> listAll();

	public void save(Medico medico);

	public Medico get(Long id);

	public void delete(Long id);
}
