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

import com.bd.menuminuto.model.Cliente;
import com.bd.menuminuto.model.ClienteService;
import com.bd.menuminuto.model.Tool;

import jakarta.websocket.server.PathParam;

@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") 
    public String Principal(){
        return "principal"; 
    }

    @GetMapping("/atualizar/{id}") 
    public String atualizar(Model model, @PathVariable int id){
        ClienteService cs = context.getBean(ClienteService.class);
        Cliente cli = cs.obterCliente(id);
        model.addAttribute("id", id);
        model.addAttribute("cliente", cli);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Cliente cli){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.atualizarCliente(id, cli);
        return "redirect:/listagem";
    }

    @GetMapping("/cadastro") 
    public String cadastro(Model model){
        model.addAttribute("cliente", new Cliente("","","",null));
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Cliente cli){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserir(cli);
        return "admin";
    }

    @GetMapping("/listagem")
    public String listagem(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> lista = cs.obterTodosClientes();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        for(Map<String,Object> registro : lista){
            listaClientes.add(Tool.converterCliente(registro));
        }
        model.addAttribute("clientes", listaClientes);
        return "listagem";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.deletarCliente(id);
        return "redirect:/listagem";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}