package mx.utng.s26.sesion26.model.service;

import java.util.List;
import mx.utng.s26.sesion26.model.entity.RegistroProgreso;

public interface IRegistroProgresoService {
    List<RegistroProgreso> list();
    void save(RegistroProgreso registroProgreso);
    RegistroProgreso getById(Long id);
    void delete(Long id);
}
