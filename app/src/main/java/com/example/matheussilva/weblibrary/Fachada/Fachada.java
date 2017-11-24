package com.example.matheussilva.weblibrary.Fachada;

import android.content.Context;

import com.example.matheussilva.weblibrary.BClasses.Usuario;
import com.example.matheussilva.weblibrary.Negocio.UsuarioNegocio;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class Fachada {

    private static Fachada fachada;
    UsuarioNegocio usuarioNegocio;
    ServicoNegocio servicoNegocio;

    public static Fachada getInstance(Context context) {
        if (fachada == null)
            fachada = new Fachada(context);
        return fachada;
    }

    public Fachada(Context context) {
        usuarioNegocio = new UsuarioNegocio(context);
        servicoNegocio = new ServicoNegocio(context);
    }

    //Usuário
    public Usuario usuarioLogar(String email, String senha) throws NegocioException {
        return usuarioNegocio.logar(email, senha);
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
    public List<Servico> ListarServicosUsuario(Usuario usuarioLogado) {
        return servicoNegocio.ListarServicosUsuario(usuarioLogado);
    }

    public void servicoInserir(Servico servico) {
        servicoNegocio.inserir(servico);
    }
}
