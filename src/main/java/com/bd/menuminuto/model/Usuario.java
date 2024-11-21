package com.bd.menuminuto.model;

import java.sql.Date;

public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String senha; 
    private Date nascimento;


    public Usuario(){
        
    }

    //Sobrecarga dos construtores Usuario
    public Usuario(int id, String nome, String email, String senha, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
    }
    public Usuario(String nome, String email, String senha, Date nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
    }    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Date getNascimento() {
        return nascimento;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}