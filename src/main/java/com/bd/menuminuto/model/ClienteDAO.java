package com.bd.menuminuto.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
    /* DAO = Data Acssess Object */

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Cliente cli){
        String sql = "INSERT INTO cliente(nome,email,senha,nascimento) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getEmail();
        parametros[2] = cli.getSenha();
        parametros[3] = cli.getNascimento();
        jdbc.update(sql,parametros);
    }

    //[ {id: 1, nome: teste1, email: teste1@teste, senha: 123456, nascimento: 2000-10-10}
    //, {id: 2, nome: teste2, email: teste2@teste, senha: 123456, nascimento: 1997-10-10}
    //]
    public List<Map<String,Object>> obterTodosClientes(){
        String sql = "Select * from cliente;";
        return jdbc.queryForList(sql);
    }

    public void atualizarCliente(int id, Cliente cli){
        String sql = "UPDATE cliente SET ";
        sql += "nome = ?, email = ?, senha = ?, nascimento = ? WHERE id = ?";
        jdbc.update(sql, cli.getNome(), cli.getEmail(), cli.getSenha(), cli.getNascimento(), id);
    }

    public Cliente obterCliente(int id){
        String sql = "Select * from cliente where id = ?";
        return Tool.converterCliente(jdbc.queryForMap(sql,id));
    }

    public void deletarCliente(int id){
        String sql = "DELETE FROM cliente where id = ?";
        jdbc.update(sql,id);
    }
}
