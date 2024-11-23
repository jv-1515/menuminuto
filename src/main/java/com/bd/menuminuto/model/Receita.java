package com.bd.menuminuto.model;

public class Receita {
    
    private int id;
    private String nome;
    private String descricao;
    private Integer preparo;
    private String imagem;

    public Receita(){   
    }

    //Sobrecarga dos construtores Receita
    public Receita(int id, String nome, String descricao, Integer preparo, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preparo = preparo;
        this.imagem = imagem;
    }
    
    public Receita(String nome, String descricao, Integer preparo, String imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preparo = preparo;
        this.imagem = imagem;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getPreparo() {
        return preparo;
    }
    public void setPreparo(Integer preparo) {
        this.preparo = preparo;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}