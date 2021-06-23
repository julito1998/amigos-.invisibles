package com.amigosinvisibles.gdp.controller;

import com.amigosinvisibles.gdp.dto.GrupoAdministroDTO;
import com.amigosinvisibles.gdp.dto.GrupoPertenezcoDTO;
import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.service.IGrupoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// mapping? (creo que es sin el /grupos)
@RequestMapping ("/grupos")
public class GrupoController {

    @Autowired
    //indica que vamos a inyectar un componente que esta en memoria
    @Qualifier("grupoService")
    //indica el nombre el bin en memoria que inyectamos
    //seguido de eso se declara
    private IGrupoService grupoService;

    @Autowired
    private ModelMapper modelMapper;

    //necesito la vista inicial de crear un nuevo grupo para devolver la de pertenezco
    //necesito try/catch?
    //creo que deberia usar model mapper
    @GetMapping ("/pertenezco")
    public String pertenezco(Model model){
        model.addAttribute("grupo", new GrupoPertenezcoDTO());
        return "pertenezco";
    }

    //necesito try/catch?
    //creo que deberia usar model mapper
    @GetMapping ("/administro")
    public String administro(Model model){
        model.addAttribute("grupo", new GrupoAdministroDTO());
        return "administro";
    }

    //quieren volver a pertenezco o a administro?
    //recordar que el tag del html tiene que llamarse "grupo" para agregar
    //falta el boton y formulario en el html
    @PostMapping("/createGrupo")
    public String create(@ModelAttribute ("grupo") Grupo grupo) throws Exception {
        grupoService.create(grupo);
        return "redirect:/pertenezco";
    }

}
