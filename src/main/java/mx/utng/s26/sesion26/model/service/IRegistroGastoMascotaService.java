package mx.utng.s26.sesion26.model.service;

import mx.utng.s26.sesion26.model.entity.RegistroGastoMascota;
import java.util.List;

public interface IRegistroGastoMascotaService {
    List<RegistroGastoMascota> list();
    void save(RegistroGastoMascota registroGastoMascota);
    RegistroGastoMascota getById(Long id);
    void delete(Long id);
}