package com.example.matheussilva.weblibrary.BClasses;

import java.io.Serializable;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class Service implements Serializable {

    private int id;
    private Usuario usuario;
    private Categoria categoria;
    private String status;
    private int prazoEntrega; //prazo de entrega dos livros
    private int prazoBuscaPorAgendamento; //prazo de entrega dos livros

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public int getPrazoBuscaPorAgendamento() {
        return prazoBuscaPorAgendamento;
    }

    public void setPrazoBuscaPorAgendamento(int prazoBuscaPorAgendamento) {
        this.prazoBuscaPorAgendamento = prazoBuscaPorAgendamento;
    }
}
