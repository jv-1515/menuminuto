package com.bd.menuminuto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.menuminuto.model.Usuario;
import com.bd.menuminuto.model.UsuarioService;
import com.bd.menuminuto.model.Tool;

import jakarta.websocket.server.PathParam;

@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;
    
    //atualizar
    @GetMapping("/atualizar/{id}") 
    public String atualizar(Model model, @PathVariable int id){
        UsuarioService cs = context.getBean(UsuarioService.class);
        Usuario usu = cs.obterUsuario(id);
        model.addAttribute("id", id);
        model.addAttribute("usuario", usu);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Usuario usu){
        UsuarioService cs = context.getBean(UsuarioService.class);
        cs.atualizarUsuario(id, usu);
        return "redirect:/listagem";
    }

    //cadastro
    @GetMapping("/cadastro") 
    public String cadastro(Model model){
        model.addAttribute("usuario", new Usuario("","","",null));
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Usuario usu){
        UsuarioService cs = context.getBean(UsuarioService.class);
        cs.inserir(usu);
        return "admin";
    }

    //listagem
    @GetMapping("/listagem")
    public String listagem(Model model){
        UsuarioService cs = context.getBean(UsuarioService.class);
        List<Map<String,Object>> lista = cs.obterTodosUsuarios();
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        for(Map<String,Object> registro : lista){
            listaUsuarios.add(Tool.converterUsuario(registro));
        }
        model.addAttribute("usuarios", listaUsuarios);
        return "listagem";
    }

    //deletar
    @PostMapping("/deletar-usuario/{id}")
    public String deletar(@PathVariable int id){
        UsuarioService cs = context.getBean(UsuarioService.class);
        cs.deletarUsuario(id);
        return "redirect:/listagem";
    }

    //admin
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    //login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}