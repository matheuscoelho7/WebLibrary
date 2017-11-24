package com.example.matheussilva.weblibrary.Fachada;

import android.content.Context;

import com.example.matheussilva.weblibrary.ClassesBasicas.Service;
import com.example.matheussilva.weblibrary.ClassesBasicas.Usuario;
import com.example.matheussilva.weblibrary.Negocio.ServiceNegocio;
import com.example.matheussilva.weblibrary.Negocio.UsuarioNegocio;
import com.example.matheussilva.weblibrary.Util.NegocioException;

import java.util.List;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class Fachada {

    private static Fachada fachada;
    UsuarioNegocio usuarioNegocio;
    ServiceNegocio servicoNegocio;

    public static Fachada getInstance(Context context) {
        if (fachada == null)
            fachada = new Fachada(context);
        return fachada;
    }

    public Fachada(Context context) {
        usuarioNegocio = new UsuarioNegocio(context);
        servicoNegocio = new ServiceNegocio(context);
    }

    //Usuário
    public Usuario usuarioLogar(String login, String senha) throws NegocioException {
        return usuarioNegocio.logar(login, senha);
    }

    public void usuarioAlterar(Usuario usuario) {
        usuarioNegocio.alterar(usuario);
    }

    public void usuarioInserir(Usuario usuario) {
        usuarioNegocio.inserir(usuario);
    }

    public Usuario usuarioLogado() {
        return usuarioNegocio.usuarioLogado();
    }

    public void usuarioExcluirLogado() {
        usuarioNegocio.usuarioExcluirLogado();
    }

    public void usuarioAtualizarUsuarioLogado(Usuario usuario){ usuarioNegocio.usuarioAtualizarUsuarioLogado(usuario);}

    //Serviços
    public List<Service> ListarServicosUsuario(Usuario usuarioLogado) {
        return servicoNegocio.ListarServicosUsuario(usuarioLogado);
    }

    public void servicoInserir(Service servico) {
        servicoNegocio.inserir(servico);
    }
}
