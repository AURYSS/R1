package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.ListaDeseosJuegos;

public interface IListaDeseosJuegosDao {
    List<ListaDeseosJuegos> list();
    void save(ListaDeseosJuegos listaJuegosDeseos);
    ListaDeseosJuegos getById(Long id);
    void delete(Long id);
    
} 
