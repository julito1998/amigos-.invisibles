package com.amigosinvisibles.gdp.controller;

import com.amigosinvisibles.gdp.dto.*;
import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.service.IGrupoService;
import com.amigosinvisibles.gdp.service.IGustoService;
import com.amigosinvisibles.gdp.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Julito
 */
@Controller
@RequestMapping("/users")
public class UserController {

    final static Logger LOG = Logger.getLogger(UserController.class.getName());

    @Autowired
    private IUserService userService;

    @Autowired
    private IGrupoService grupoService;

    @Autowired
    private IGustoService gustoService;

    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("user", new UserNewDTO());
        return "users/new";
    }

    @PostMapping("/new")
    public String regist(@ModelAttribute UserNewDTO userDTO){
        try{
            User user = modelMapper.map(userDTO, User.class);
            user.setBirthDate(userDTO.getBirthDateInDateConverted());
            userService.create(user);
            return "users/login";
        }catch(UsernameNotFoundException errorU){
            LOG.log(Level.WARNING,"users/new " + errorU.getMessage());
            return "/error";
        }catch (Exception e){
            LOG.log(Level.WARNING,"users/new " + e.getMessage());
            return "/error";
        }
    }

    @GetMapping(value = "/login")
    public String userLogin(Model model){
        model.addAttribute("user", new UserLoginDTO());
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDTO user, Model model) {
        try {
            User user1= (User) userService.loadUserByUsername(user.getEmail());
            model.addAttribute("idUser", user1.getId());
            model.addAttribute("firstName", user1.getFirstName());
            return "redirect:/principal";
        } catch (UsernameNotFoundException ex) {
            LOG.log(Level.WARNING,"users/login " + ex.getMessage());
            return "/error";
        }
    }


    /**Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDetails userDetails = null;
            if (principal instanceof UserDetails) {
        userDetails = (UserDetails) principal;
    }
    User userName =(User) userDetails;
**/
    @GetMapping(value = "/perfil/{idUser}")
    public String userPerfil(@PathVariable String idUser, Model model){
        try {
            UserPerfilDTO userPerfilDTO= new UserPerfilDTO();
            User user = userService.getOne(Long.parseLong(idUser));
            userPerfilDTO.setFirstName(user.getFirstName());
            userPerfilDTO.setLastName(user.getLastName());
            if (user!= null){
                List<GustoDTO> gustoDTOList = gustoService.findAllByUserId(Long.parseLong(idUser))
                        .stream()
                        .map(gusto -> modelMapper.map(gusto, GustoDTO.class)).collect(Collectors.toList());
                userPerfilDTO.setGustos(gustoDTOList);

                userPerfilDTO.setCantidadGruposAdministra(userService.cantidadGruposAdministrados(Long.parseLong(idUser)));
                userPerfilDTO.setCantidadGruposPertenece(userService.cantidadGruposParticipados(Long.parseLong(idUser)));
            }
            model.addAttribute("perfil", userPerfilDTO);
            return "users/perfil";
        } catch (UsernameNotFoundException ex) {
            LOG.log(Level.WARNING,"users/perfil/{idUser} " + ex.getMessage());
            return "/error";
        } catch (Exception e) {
            LOG.log(Level.WARNING,"users/perfil/{idUser} " + e.getMessage());
            return "/error";
        }

    }


}
