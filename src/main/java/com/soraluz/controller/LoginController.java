package com.soraluz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soraluz.model.bd.Usuario;
import com.soraluz.service.UsuarioService;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(){
        return "user/frmLogin";
    }
    @GetMapping("/registrar")
    public String registrar(){
        return "user/frmRegistro";
    }

    @PostMapping("/registrarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/auth/login";
    }

}
