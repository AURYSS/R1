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
import mx.utng.s26.sesion26.model.entity.RegistroProgreso;
import mx.utng.s26.sesion26.model.service.IRegistroProgresoService;

@Controller
@SessionAttributes("registroProgreso")
public class RegistroProgresoController {
    
     @Autowired
    private IRegistroProgresoService service;

    @GetMapping({"/registroProgreso", "/registroProgreso/", "/registroProgreso/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado Registro Progreso");
        model.addAttribute("registroProgresos", service.list());
        return "registroProgreso-list";
    }

    @GetMapping("/registroProgreso/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario Registro Progreso");
        model.addAttribute("registroProgreso", new RegistroProgreso());
        return "registroProgreso-form";
    }

    @PostMapping("/registroProgreso/form")
    public String save(@Valid RegistroProgreso registroProgreso, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario Registro Progreso");
            return "registroProgreso-form";
        }
        service.save(registroProgreso);
        return "redirect:/registroProgreso/list";
    }

    @GetMapping("/registroProgreso/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroProgreso registroProgreso = null;
        if(id>0){
            registroProgreso = service.getById(id);
        }else{
            return "redirect:/registroProgreso/list";
        }
        model.addAttribute("title", "Editar Registro Progreso");
        model.addAttribute("registroProgreso", registroProgreso);
        return "registroProgreso-form";
    }

    @GetMapping("/registroProgreso/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/registroProgreso/list";
    }



}