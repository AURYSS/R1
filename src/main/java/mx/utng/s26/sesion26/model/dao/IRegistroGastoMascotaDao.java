package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.RegistroGastoMascota;

public interface IRegistroGastoMascotaDao {
    List<RegistroGastoMascota> list();
    void save(RegistroGastoMascota registroGastoMascota);
    RegistroGastoMascota getById(Long id);
    void delete(Long id);
}