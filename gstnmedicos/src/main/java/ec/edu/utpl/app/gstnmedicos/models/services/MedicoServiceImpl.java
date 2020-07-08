package ec.edu.utpl.app.gstnmedicos.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.utpl.app.gstnmedicos.models.dao.IMedicoDao;
import ec.edu.utpl.app.gstnmedicos.models.entity.Medico;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoDao medicoDao;

	@Override
	public List<Medico> listAll() {
		// TODO Auto-generated method stub
		return medicoDao.findAll();
	}

	@Override
	public void save(Medico medico) {
		medicoDao.save(medico);

	}

	@Override
	public Medico get(Long id) {
		// TODO Auto-generated method stub
		return medicoDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		medicoDao.deleteById(id);

	}

}
