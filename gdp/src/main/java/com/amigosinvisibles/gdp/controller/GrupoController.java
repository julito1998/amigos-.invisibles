package com.amigosinvisibles.gdp.controller;

import com.amigosinvisibles.gdp.dto.GrupoAdministroDTO;
import com.amigosinvisibles.gdp.dto.GrupoPertenezcoDTO;
import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.service.IGrupoService;
import com.amigosinvisibles.gdp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
// mapping? (creo que es sin el /grupos)
@RequestMapping ("/grupos")
public class GrupoController {

    final static Logger LOG = Logger.getLogger(GrupoController.class.getName());

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
    @GetMapping ("/pertenezco/{idUser}")
    public String pertenezco(@PathVariable String idUser,Model model){
        try{
            List<GrupoPertenezcoDTO> grupoPertenezcoDTO = grupoService.listAllUser(Long.parseLong(idUser))
                    .stream()
                    .map(grupo -> modelMapper.map(grupo,GrupoPertenezcoDTO.class))
                    .collect(Collectors.toList());
            model.addAttribute("grupoPertenezco", grupoPertenezcoDTO);
            return "grupos/pertenezco";
        }catch (Exception e){
            LOG.log(Level.WARNING,"grupos/pertenezco/{idUser} " + e.getMessage());
            return "/error";
        }

    }

    //necesito try/catch?
    //creo que deberia usar model mapper
    /**@GetMapping ("/administro")
    public String administro(Model model){
        model.addAttribute("grupo", new GrupoAdministroDTO());
        return "administro";
    }**/

    @GetMapping("/administro/{idUser}")
    public String userInGrupo(@PathVariable String idUser, Model model){
        try{
            List<GrupoAdministroDTO> grupoAdministroDTOS = grupoService.listAlluserByAdmin(Long.parseLong(idUser))
                    .stream()
                    .map(grupo -> modelMapper.map(grupo,GrupoAdministroDTO.class))
                    .collect(Collectors.toList());

            for (GrupoAdministroDTO g:grupoAdministroDTOS) {
                if (g.getFechaLimite().before(new Date())){
                    g.setActivo(true);
                }else {
                    g.setActivo(false);
                }
            }

            model.addAttribute("grupoAdministro", grupoAdministroDTOS);
            return "grupos/administro";
        }catch (Exception e){
            LOG.log(Level.WARNING,"grupos/administro/{idUser} " + e.getMessage());
            return "/error";
        }
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
