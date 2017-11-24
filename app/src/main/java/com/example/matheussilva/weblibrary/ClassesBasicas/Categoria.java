package com.example.matheussilva.weblibrary.ClassesBasicas;

import java.io.Serializable;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class Categoria implements Serializable {

    //Esta é a classe LIVRO
    private int id;
    private String descricao;
    private String caminhoImagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String imagem) {
        this.caminhoImagem = imagem;
    }
}
