package mx.utng.s26.sesion26.model.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.RegistroProgreso;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

@Repository
public class RegistroProgresoDaoImpl implements IRegistroProgresoDao {
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<RegistroProgreso> list() {
        return em.createQuery("from RegistroProgreso").getResultList();
    }

    @Override
    public void save(RegistroProgreso registroProgreso) {
        System.out.println("RegistroProgreso id="+registroProgreso.getId());
        if(registroProgreso.getId() != null && registroProgreso.getId() >0){
            //Actualizo estudiante
            em.merge(registroProgreso);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(registroProgreso);
        }
    }

    @Override
    public RegistroProgreso getById(Long id) {
        return em.find(RegistroProgreso.class, id);
    }

    @Override
    public void delete(Long id) {
        RegistroProgreso registroProgreso = getById(id);
        em.remove(registroProgreso);
    }

    
}