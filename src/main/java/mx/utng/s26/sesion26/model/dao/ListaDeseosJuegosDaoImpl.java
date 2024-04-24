package mx.utng.s26.sesion26.model.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.ListaDeseosJuegos;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

@Repository
public class ListaDeseosJuegosDaoImpl implements IListaDeseosJuegosDao {
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ListaDeseosJuegos> list() {
        return em.createQuery("from ListaDeseosJuegos").getResultList();
    }

    @Override
    public void save(ListaDeseosJuegos listaDeseosJuegos) {
        System.out.println("listaDeseosJuegos id="+listaDeseosJuegos.getId());
        if(listaDeseosJuegos.getId() != null && listaDeseosJuegos.getId() >0){
            //Actualizo estudiante
            em.merge(listaDeseosJuegos);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(listaDeseosJuegos);
        }
    }

    @Override
    public ListaDeseosJuegos getById(Long id) {
        return em.find(ListaDeseosJuegos.class, id);
    }

    @Override
    public void delete(Long id) {
        ListaDeseosJuegos listaDeseosJuegos = getById(id);
        em.remove(listaDeseosJuegos);
    }

    
}