package mx.utng.s26.sesion26.model.service;

import java.util.List;
import mx.utng.s26.sesion26.model.entity.ListaDeseosJuegos;

public interface IListaDeseosJuegosService {
    List<ListaDeseosJuegos> list();
    void save(ListaDeseosJuegos listaDeseosJuegos);
    ListaDeseosJuegos getById(Long id);
    void delete(Long id);
}
