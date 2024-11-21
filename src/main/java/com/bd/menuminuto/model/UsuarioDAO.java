package com.bd.menuminuto.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class UsuarioDAO {
    /* DAO = Data Acssess Object */

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Usuario usu){
        String sql = "INSERT INTO usuarios(nome,email,senha,nascimento) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = usu.getNome();
        parametros[1] = usu.getEmail();
        parametros[2] = usu.getSenha();
        parametros[3] = usu.getNascimento();
        jdbc.update(sql,parametros);
    }

    //[ {id: 1, nome: teste1, email: teste1@teste, senha: 123456, nascimento: 2000-10-10}
    //, {id: 2, nome: teste2, email: teste2@teste, senha: 123456, nascimento: 1997-10-10}
    //]
    public List<Map<String,Object>> obterTodosUsuarios(){
        String sql = "SELECT * FROM usuarios;";
        return jdbc.queryForList(sql);
    }

    public void atualizarUsuario(int id, Usuario usu){
        String sql = "UPDATE usuarios SET ";
        sql += "nome = ?, email = ?, senha = ?, nascimento = ? WHERE id = ?";
        jdbc.update(sql, usu.getNome(), usu.getEmail(), usu.getSenha(), usu.getNascimento(), id);
    }

    public Usuario obterUsuario(int id){
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        return Tool.converterUsuario(jdbc.queryForMap(sql,id));
    }

    public void deletarUsuario(int id){
        String sql = "DELETE FROM usuarios WHERE id = ?";
        jdbc.update(sql,id);
    }
}
