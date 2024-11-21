package com.bd.menuminuto.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    // CONEXAO É O SERVICE, OU SEJA, O FRONT SO ENXERGA AQUI, ENQUANTO O DAO É ESCONDIDO (A VIEW NAO O VÊ)
    
    @Autowired
    UsuarioDAO cdao;

    public void inserir(Usuario usu){
        cdao.inserir(usu);
    }

    public List<Map<String,Object>> obterTodosUsuarios(){
        return cdao.obterTodosUsuarios();
    }

    public void atualizarUsuario(int id, Usuario usu){
        cdao.atualizarUsuario(id, usu);
    }

    public Usuario obterUsuario(int id){
        return cdao.obterUsuario(id);
    }

    public void deletarUsuario(int id){
        cdao.deletarUsuario(id);
    }
}
