package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.IRegistroGastoMascotaDao;
import mx.utng.s26.sesion26.model.entity.RegistroGastoMascota;

@Service
public class RegistroGastoMascotaServiceImpl implements IRegistroGastoMascotaService{

    @Autowired
    private IRegistroGastoMascotaDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<RegistroGastoMascota> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroGastoMascota registroGastoMascota) {
        dao.save(registroGastoMascota);
    }

    @Transactional(readOnly = true)
    @Override
    public RegistroGastoMascota getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}