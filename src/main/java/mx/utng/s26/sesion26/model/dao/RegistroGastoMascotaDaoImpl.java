package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.RegistroGastoMascota;

@Repository
public class RegistroGastoMascotaDaoImpl implements IRegistroGastoMascotaDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<RegistroGastoMascota> list() {
        return em.createQuery("from RegistroGastoMascota").getResultList();
    }

    @Override
    public void save(RegistroGastoMascota registroGastoMascota) {
        System.out.println("RegistroGastoMascota id="+registroGastoMascota.getId());
        if(registroGastoMascota.getId() != null && registroGastoMascota.getId() >0){
            em.merge(registroGastoMascota);
        }else{
            em.persist(registroGastoMascota);
        }
    }

    @Override
    public RegistroGastoMascota getById(Long id) {
        return em.find(RegistroGastoMascota.class, id);
    }

    @Override
    public void delete(Long id) {
        RegistroGastoMascota registroGastoMascota = getById(id);
        em.remove(registroGastoMascota);
    }

    
}