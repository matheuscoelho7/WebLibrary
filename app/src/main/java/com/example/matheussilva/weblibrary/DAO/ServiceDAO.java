package com.example.matheussilva.weblibrary.DAO;

import android.content.Context;

import com.example.matheussilva.weblibrary.BClasses.Usuario;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class ServiceDAO {

    ServiceDAO servicoDAO;

    public ServiceDAO(Context context) {
        servicoDAO = new ServiceDAO(context);
    }

    public List<Servico> ListarServicosUsuario(Usuario usuarioLogado) {
        Servico servico = new Servico();
        return servicoDAO.buscarServico(servico, usuarioLogado);
    }

    public void inserir(Servico servico){
        servicoDAO.salvar(servico);
    }

}
