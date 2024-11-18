package com.bd.menuminuto.model;

import java.util.Map;

public class Tool {

    public static Cliente converterCliente(Map<String,Object> registro){
        //Como registro.get retorna Object, devemos usar o polimorfismo
        //de subtipos (downcast) para recuperar os tipos originais.
        return new Cliente((Integer) registro.get("id")
                          ,(String) registro.get("nome")
                          ,(String) registro.get("email")
                            ,(String) registro.get("senha"));
    }

    public static Receita converterReceita(Map<String,Object> registro){
        return new Receita((Integer) registro.get("id")
                          ,(String) registro.get("nome")
                          ,(String) registro.get("descricao")
                          ,(Integer) registro.get("preparo")
                          ,(String) registro.get("imagem"));
    }
}