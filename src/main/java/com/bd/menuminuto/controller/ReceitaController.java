package com.bd.menuminuto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.bd.menuminuto.model.Receita;
import com.bd.menuminuto.model.ReceitaService;
import com.bd.menuminuto.model.Tool;
import com.bd.menuminuto.utils.UploadUtil;

import jakarta.websocket.server.PathParam;

@Controller
public class ReceitaController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") 
    public String principal(Model model){
        ReceitaService cs = context.getBean(ReceitaService.class);
        List<Map<String,Object>> lista = cs.obterTodasReceitas();
        List<Receita> listaReceitas = new ArrayList<Receita>();
        for(Map<String,Object> registro : lista){
            listaReceitas.add(Tool.converterReceita(registro));
        }
        model.addAttribute("receitas", listaReceitas);
        return "principal";
    }


    @GetMapping("/receita/{id}") 
    public String atualizarReceita(Model model, @PathVariable int id){
        ReceitaService cs = context.getBean(ReceitaService.class);
        Receita rec = cs.obterReceita(id);
        model.addAttribute("id", id);
        model.addAttribute("receita", rec);
        return "atualizar-receita";
    }

    @PostMapping("/receita/{id}")
    public String atualizarReceita(@PathVariable int id, @ModelAttribute Receita rec){
        ReceitaService cs = context.getBean(ReceitaService.class);
        cs.atualizarReceita(id, rec);
        return "redirect:/listagem-receita";
    }

    @GetMapping("/cadastro-receita")
    public String cadastroReceita(Model model){
        model.addAttribute("receita", new Receita("","",0,""));
        return "cadastro-receita";
    }

    // @PostMapping("/receita")
    // public String cadastrarReceita(Model model, @ModelAttribute Receita rec){
    //     ReceitaService cs = context.getBean(ReceitaService.class);
    //     cs.inserir(rec);
    //     return "admin";
    // }

    @PostMapping("/receita")
    public String cadastrarReceita(Model model, @ModelAttribute Receita rec, @RequestParam("foto") MultipartFile foto){
        ReceitaService cs = context.getBean(ReceitaService.class);
        if (foto != null && !foto.isEmpty()) {
            if (UploadUtil.fazerUploadImagem(foto)) {
                String img = foto.getOriginalFilename();
                rec.setImagem(img);
            } else {
                return "admin";
            }
        }
        cs.inserir(rec);
        return "admin";

    }

    @GetMapping("/receita")
    public String listagemReceita(Model model){
        ReceitaService cs = context.getBean(ReceitaService.class);
        List<Map<String,Object>> lista = cs.obterTodasReceitas();
        List<Receita> listaReceitas = new ArrayList<Receita>();
        for(Map<String,Object> registro : lista){
            listaReceitas.add(Tool.converterReceita(registro));
        }
        model.addAttribute("receitas", listaReceitas);
        return "listagem-receita";
    }

    @DeleteMapping("/receita/{id}")
    public String deletarReceita(@PathVariable int id){
        ReceitaService cs = context.getBean(ReceitaService.class);
        cs.deletarReceita(id);
        return "redirect:/listagem-receita";
    }    

    @GetMapping("/atualizar-receita")
    public String atualizarReceita() {
        return "atualizar-receita";
    }
}