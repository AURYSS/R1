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
import mx.utng.s26.sesion26.model.entity.ListaDeseosJuegos;
import mx.utng.s26.sesion26.model.service.IListaDeseosJuegosService;

@Controller
@SessionAttributes("listaDeseosJuegos")
public class ListaDeseosJuegosController {
    
     @Autowired
    private IListaDeseosJuegosService service;

    @GetMapping({"/listaDeseosJuegos", "/listaDeseosJuegos/", "/listaDeseosJuegos/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Deseos Juegos");
        model.addAttribute("listaDeseosJuegoss", service.list());
        return "listaDeseosJuegos-list";
    }

    @GetMapping("/listaDeseosJuegos/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Deseos Juegos");
        model.addAttribute("listaDeseosJuegos", new ListaDeseosJuegos());
        return "listaDeseosJuegos-form";
    }

    @PostMapping("/listaDeseosJuegos/form")
    public String save(@Valid ListaDeseosJuegos listaDeseosJuegos, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Deseos Juegos");
            return "listaDeseosJuegos-form";
        }
        service.save(listaDeseosJuegos);
        return "redirect:/listaDeseosJuegos/list";
    }

    @GetMapping("/listaDeseosJuegos/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaDeseosJuegos listaDeseosJuegos = null;
        if(id>0){
            listaDeseosJuegos = service.getById(id);
        }else{
            return "redirect:/listaDeseosJuegos/list";
        }
        model.addAttribute("title", "Editar Deseos Juegos");
        model.addAttribute("listaDeseosJuegos", listaDeseosJuegos);
        return "listaDeseosJuegos-form";
    }

    @GetMapping("/listaDeseosJuegos/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/listaDeseosJuegos/list";
    }



}