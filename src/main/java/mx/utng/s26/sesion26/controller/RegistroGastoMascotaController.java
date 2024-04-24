package mx.utng.s26.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.RegistroGastoMascota;
import mx.utng.s26.sesion26.model.service.IRegistroGastoMascotaService;

@Controller
@SessionAttributes("registroGastoMascota")
public class RegistroGastoMascotaController {
    
    @Autowired
    private IRegistroGastoMascotaService service;

    @GetMapping({"/registroGastoMascota", "/registroGastoMascota/", "/registroGastoMascota/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Registro Gasto Mascota");
        model.addAttribute("registroGastoMascotas", service.list()); 
        return "registroGastoMascota-list";
    }

    @GetMapping("/registroGastoMascota/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Registro Gasto Mascota");
        model.addAttribute("registroGastoMascota", new RegistroGastoMascota());
        return "registroGastoMascota-form";
    }

    @PostMapping("/registroGastoMascota/form")
    public String save(@Valid RegistroGastoMascota registroGastoMascota, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de registro gasto mascota");
            return "registroGastoMascota-form";
        }
        service.save(registroGastoMascota);
        return "redirect:/registroGastoMascota/list";
    }

    @GetMapping("/registroGastoMascota/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroGastoMascota registroGastoMascota = null;
        if(id>0){
            registroGastoMascota = service.getById(id);
        }else{
            return "redirect:/registroGastoMascota/list";
        }
        model.addAttribute("title", "Editar Registro");
        model.addAttribute("registroGastoMascota", registroGastoMascota);
        return "registroGastoMascota-form";
    }

    @GetMapping("/registroGastoMascota/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/registroGastoMascota/list";
    }



}