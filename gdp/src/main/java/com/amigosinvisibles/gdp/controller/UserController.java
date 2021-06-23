package com.amigosinvisibles.gdp.controller;

import com.amigosinvisibles.gdp.dto.UserLoginDTO;
import com.amigosinvisibles.gdp.dto.UserNewDTO;
import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Julito
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("user", new UserNewDTO());
        return "/HTML/new";
    }

    @PostMapping("/new")
    public String regist(@ModelAttribute UserNewDTO userDTO, Model model){
        try{
            User user = modelMapper.map(userDTO, User.class);
            user.setBirthDate(userDTO.getBirthDateInDateConverted());
            userService.create(user);
            return "/HTML/login";
        }catch(UsernameNotFoundException errorU){
            model.addAttribute("error",errorU.getMessage());
            return "/error";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "/error";
        }
    }

    @GetMapping("/login")
    public String userLogin(Model model){
        model.addAttribute("user", new UserLoginDTO());
        return "/HTML/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDTO user, Model model) {
        try {
            userService.loadUserByUsername(user.getEmail());
            return "/HTML/principal";
        } catch (UsernameNotFoundException ex) {
            model.addAttribute("error",ex.getMessage());
            return "/error";
        }
    }

}
