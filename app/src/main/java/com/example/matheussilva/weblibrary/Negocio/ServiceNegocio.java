package com.example.matheussilva.weblibrary.Negocio;

import android.content.Context;

import com.example.matheussilva.weblibrary.ClassesBasicas.Service;
import com.example.matheussilva.weblibrary.ClassesBasicas.Usuario;
import com.example.matheussilva.weblibrary.DAO.ServiceDAO;

import java.util.List;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class ServiceNegocio {
    ServiceDAO serviceDAO;

    public ServiceNegocio(Context context) {
        serviceDAO = new ServiceDAO(context);
    }

    public List<Service> ListarServicosUsuario(Usuario usuarioLogado) {
        Service servico = new Service();
        return serviceDAO.buscarServico(servico, usuarioLogado);
    }

    public void inserir(Service servico){
        serviceDAO.salvar(servico);
    }
}
