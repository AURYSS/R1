package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.IListaDeseosJuegosDao;
import mx.utng.s26.sesion26.model.entity.ListaDeseosJuegos;



/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class ListaDeseosJuegosServiceImpl implements IListaDeseosJuegosService {
     //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IListaDeseosJuegosDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseosJuegos> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseosJuegos ListaDeseosJuegos) {
        dao.save(ListaDeseosJuegos);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseosJuegos getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}