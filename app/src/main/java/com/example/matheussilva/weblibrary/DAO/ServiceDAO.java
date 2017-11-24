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

    private List<Service> buscarServico(Service servico, Usuario usuarioLogado) {
        //IMPLEMENTAR MÉTODO
        return null;
    }

    public void inserir(Service servico){
        servicoDAO.salvar(servico);
    }

    private void salvar(Service servico) {
        //IMPLEMENTAR MÉTODO
    }

}
