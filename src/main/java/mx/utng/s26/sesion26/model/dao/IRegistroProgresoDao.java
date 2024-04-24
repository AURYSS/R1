package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.RegistroProgreso;

public interface IRegistroProgresoDao {
    List<RegistroProgreso> list();
    void save(RegistroProgreso registroProgreso);
    RegistroProgreso getById(Long id);
    void delete(Long id);
    
} 
