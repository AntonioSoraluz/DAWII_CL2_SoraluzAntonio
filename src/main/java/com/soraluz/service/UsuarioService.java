package com.soraluz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soraluz.model.bd.Rol;
import com.soraluz.model.bd.Usuario;
import com.soraluz.repository.RolRepository;
import com.soraluz.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public Usuario buscarUsuarioPorNomusuario(String nomUsuario){
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
    public Usuario guardarUsuario(Usuario usuario){
    	usuario.setNombres(usuario.getNombres());
    	usuario.setApellidos(usuario.getApellidos());
    	usuario.setNomusuario(usuario.getNomusuario());
    	usuario.setEmail(usuario.getEmail());
        usuario.setPassword(bCryptPasswordEncoder
                .encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol rol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        return usuarioRepository.save(usuario);
    }

}
