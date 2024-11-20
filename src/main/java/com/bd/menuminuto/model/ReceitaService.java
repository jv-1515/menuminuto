package com.bd.menuminuto.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {
    // CONEXAO É O SERVICE, OU SEJA, O FRONT SO ENXERGA AQUI, ENQUANTO O DAO É ESCONDIDO (A VIEW NAO O VÊ)
    
    @Autowired
    ReceitaDAO cdao;

    public void inserir(Receita rec){
        cdao.inserir(rec);
    }

    public List<Map<String,Object>> obterTodasReceitas(){
        return cdao.obterTodasReceitas();
    }

    public void atualizarReceita(int id, Receita rec){
        cdao.atualizarReceita(id, rec);
    }

    public Receita obterReceita(int id){
        return cdao.obterReceita(id);
    }

    public void deletarReceita(int id){
        cdao.deletarReceita(id);
    }
}
