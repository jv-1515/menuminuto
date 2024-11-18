package com.bd.sitebd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {
    @GetMapping("/")
    public String principal(){
        return "principal";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        return "cadastro";
    }
}