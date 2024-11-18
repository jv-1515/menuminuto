package com.bd.sitebd.model;

import org.springframework.beans.factory.annotation.Autowired;


public class Cliente {
    private int id;
    private String nome, cpf;
    
    public Cliente(int id, String nome, String cpf){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf){es
        this.nome = nome;
        this.cpf = cpf;
    }
}