package com.bd.menuminuto.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ReceitaDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Receita rec){
        String sql = "INSERT INTO receitas(nome,descricao,preparo,imagem) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = rec.getNome();
        parametros[1] = rec.getDescricao();
        parametros[2] = rec.getPreparo();
        parametros[3] = rec.getImagem();
        jdbc.update(sql,parametros);
    }

    public List<Map<String,Object>> obterTodasReceitas(){
        String sql = "SELECT * FROM receitas ORDER BY id;";
        return jdbc.queryForList(sql);
    }

    public void atualizarReceita(int id, Receita rec){
        String sql = "UPDATE receitas SET ";
        sql += "nome = ?, descricao = ?, preparo = ?, imagem = ? WHERE id = ?";
        jdbc.update(sql, rec.getNome(), rec.getDescricao(), rec.getPreparo(), rec.getImagem(), id);
    }

    public Receita obterReceita(int id){
        String sql = "SELECT * FROM receitas WHERE id = ?";
        return Tool.converterReceita(jdbc.queryForMap(sql,id));
    }

    public void deletarReceita(int id){
        String sql = "DELETE FROM receitas WHERE id = ?";
        jdbc.update(sql,id);
    }
}
