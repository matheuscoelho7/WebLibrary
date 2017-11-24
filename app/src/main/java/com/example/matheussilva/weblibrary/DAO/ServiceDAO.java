package com.example.matheussilva.weblibrary.DAO;

import android.content.Context;

import com.example.matheussilva.weblibrary.ClassesBasicas.Service;
import com.example.matheussilva.weblibrary.ClassesBasicas.Usuario;

import java.util.List;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class ServiceDAO {

    ServiceDAO servicoDAO;

    public ServiceDAO(Context context) {
        servicoDAO = new ServiceDAO(context);
    }

    public List<Service> ListarServicosUsuario(Usuario usuarioLogado) {
        Service servico = new Service();
        return servicoDAO.buscarServico(servico, usuarioLogado);
    }

    public void inserir(Servico servico){
        servicoDAO.salvar(servico);
    }

}
